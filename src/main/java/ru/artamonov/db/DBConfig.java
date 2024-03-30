package ru.artamonov.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс помогающий распарсить db.properties
 */
public class DBConfig {
    private static final Properties properties = new Properties();

    private DBConfig() {}

    static {
        try (InputStream input = DBConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUsername() {
        return properties.getProperty("db.username");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }

}
