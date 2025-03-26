package utils;

public class UserManager {
    public static String username (String role) {
        return ConfigReader.getProperty(role +  ".username");
    }

    public static String password (String role) {
        return ConfigReader.getProperty(role + ".password");
    }
}
