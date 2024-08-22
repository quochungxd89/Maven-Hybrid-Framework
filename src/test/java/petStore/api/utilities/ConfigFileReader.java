package petStore.api.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/test/resources/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

    public Duration getLongTimeout() {
        String longTimeout = properties.getProperty("long_timeout");
        if (longTimeout != null) return Duration.ofSeconds(Long.parseLong(longTimeout));
        else throw new RuntimeException("longTimeout not specified in the config.properties file.");
    }

    public Duration getShortTimeout() {
        String shortTimeout = properties.getProperty("short_timeout");
        if (shortTimeout != null) return Duration.ofSeconds(Long.parseLong(shortTimeout));
        else throw new RuntimeException("shortTimeout not specified in the config.properties file.");
    }


    public String getChatIDGroupMobile() {
        String url = properties.getProperty("chat_id_group_mobile");
        if (url != null) return url;
        else throw new RuntimeException("chat_id not specified in the config.properties file.");
    }

    public String getPathImageMobile() {
        String url = properties.getProperty("path_image_mobile");
        if (url != null) return url;
        else throw new RuntimeException("path_image_mobile not specified in the config.properties file.");
    }

    public String getTokenTelegramBot() {
        String url = properties.getProperty("token");
        if (url != null) return url;
        else throw new RuntimeException("token not specified in the config.properties file.");
    }
}