package config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties extends Properties {
    public static ConfigProperties INSTANCE = new ConfigProperties("SdarmLessonScraper/src/main/resources/config.properties");

    private ConfigProperties(String path) {
        String property = System.getProperty("user.dir");
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDataBaseConnectionString() {
        return getProperty("database.connection_string");
    }


}
