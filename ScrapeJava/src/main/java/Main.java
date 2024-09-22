import config.ConfigProperties;
import housing.storage.HousingDataBaseConnection;
import sdarm.scrape.SdarmScraper;
import storage.SQLiteConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        switch (args[0]) {
            case "sdarm" -> sdarmScrape();
            case "housing" -> housingScrape();
            default -> System.out.println("Scraper for: " + args[0] + " does not exist");
        }
    }

    private static void housingScrape() {
        SQLiteConnection connection = new HousingDataBaseConnection(ConfigProperties.INSTANCE.getHousingConnectionString());

        connection.close();
    }

    private static void sdarmScrape() {
        SdarmScraper.start(ConfigProperties.INSTANCE.getSdarmLessonScrapeRange());
    }
}
