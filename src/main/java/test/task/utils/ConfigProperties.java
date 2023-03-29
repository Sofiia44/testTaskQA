package test.task.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private final Properties properties;

    public ConfigProperties() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseWebUrl() {
        return properties.getProperty("base_web_url");
    }

    public String getComputerWebUrl() {
        return properties.getProperty("computer_web_url");
    }
}
