package org.subham.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;
    private ConfigReader() {

    }
    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }
    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value.trim();
        }
        else {
            throw new RuntimeException(key + " not found in config.properties");
        }
    }
}
