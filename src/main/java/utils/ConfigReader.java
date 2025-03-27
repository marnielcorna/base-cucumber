package utils;

import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            // Obtaining environment from -Denv=uat parameter
            String env = System.getProperty("env", "int").toLowerCase();
            String configFileName = "config-" + env + ".properties";

            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(configFileName);
            if (input == null) {
                System.out.println("Config file not found for environment: ################## " + env.toUpperCase() + " ##################");
            } else {
                properties.load(input);
                System.out.println("Loaded configuration for environment: ################## " + env.toUpperCase() + " ##################");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        // This will look first for the direct environment
        String envVar = System.getenv(key.toUpperCase());
        if (envVar != null && !envVar.isEmpty()) {
            return envVar;
        }

        // If not defined, It will look on the properties
        String value = properties.getProperty(key);
        if (value == null) {
            return null;
        }

        // If value contains ${VAR_NAME}, It will be replaced dynamically
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String varName = matcher.group(1);
            String varValue = System.getenv(varName);
            if (varValue == null || varValue.isEmpty()) {
                System.err.println("Missing environment variable: " + varName);
                throw new RuntimeException("Missing environment variable for: " + varName);
            }
            matcher.appendReplacement(buffer, varValue);
        }
        matcher.appendTail(buffer);

        String finalValue = buffer.toString();
        if (finalValue.isEmpty()) {
            throw new RuntimeException("ERROR: Property '" + key + "' is empty. Check your environment variables or config file.");
        }

        return buffer.toString();
    }
}
