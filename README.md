# Environment Configuration Guide

This project uses dynamic environment-based configuration to securely manage URLs, credentials, and other environment-dependent parameters.

## 🔎 How it works
- Each environment (INT, UAT, PRE) has its own properties file (not committed to the repo).
- Sensitive data (i.e. usernames, passwords, tokens) are defined using placeholders in the properties file, and resolved via environment variables at runtime.
- The `ConfigReader` automatically replaces `${VAR_NAME}` placeholders with environment variable values.

## Project Structure Example
```
src/main/resources
├── config-int.properties.example
├── config-uat.properties.example
└── config-pre.properties.example
```

> The actual `config-*.properties` files (without `.example`) are ignored by Git.

## Example `config-uat.properties.example`
```properties
url=https://uat.google.com
browser=chrome
headless=true
username=${UAT_USERNAME}
password=${UAT_PASSWORD}
```

## How to create your local properties files
1. Copy the example file:
```
cp src/main/resources/config-uat.properties.example src/main/resources/config-uat.properties
```
2. Optionally, replace static values or leave placeholders for dynamic environment variables.

## How to run tests locally
- Set environment variables:
```bash
export UAT_USERNAME=myLocalUser
export UAT_PASSWORD=myLocalPassword
```
- Run with Maven, specifying the environment:
```bash
mvn clean test -Denv=uat
```

## How to configure CI/CD
- Define secrets or environment variables in your pipeline (GitHub Actions, GitLab CI, Jenkins, etc.):
```bash
UAT_USERNAME=ciSecretUser
UAT_PASSWORD=ciSecretPassword
```
- Run the Maven test phase with the desired environment:
```bash
mvn clean test -Denv=uat
```

## Priority of configuration resolution
1. Direct environment variable (ex: `USERNAME`) if defined.
2. Placeholder `${VAR_NAME}` replaced with environment variable value.
3. Static value from the properties file.

## Do not forget:
- **Never commit real `config-*.properties` files**, only the `.example` versions.
- Add this to your `.gitignore`:
```
src/main/resources/config-*.properties
```
- Document for your team that they must clone the `.example` and create their own local config file.

# Notes
## Example `ConfigReader` behavior (summary)
- Loads `config-<env>.properties` based on `-Denv=xxx`.
- Replaces placeholders `${VAR_NAME}` with `System.getenv("VAR_NAME")`.
- Returns the final value to the calling code.

## Questions?
- Feel free to reach out to the QA Automation team or consult the project documentation for additional support!

