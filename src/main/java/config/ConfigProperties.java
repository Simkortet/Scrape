package config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties extends Properties {
    public static final ConfigProperties INSTANCE = new ConfigProperties("src/main/resources/config.properties");

    private ConfigProperties(String path) {
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHousingConnectionString() {
        return getProperty("database.housing_connection_string");
    }
}
