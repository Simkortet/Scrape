package config;

import sdarm.records.SdarmLessonScrapeRange;
import sdarm.records.SdarmLessonYearQuarterNumber;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

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

    public SdarmLessonScrapeRange getSdarmLessonScrapeRange() {
        List<Integer> inputRangeParameters = Arrays.stream(getProperty("sdarm_lesson_interval_to_scrape")
                .split(","))
                .map(Integer::parseInt)
                .toList();

        return new SdarmLessonScrapeRange(
                new SdarmLessonYearQuarterNumber(
                        inputRangeParameters.get(0),
                        inputRangeParameters.get(1),
                        inputRangeParameters.get(2)),
                new SdarmLessonYearQuarterNumber(
                        inputRangeParameters.get(3),
                        inputRangeParameters.get(4),
                        inputRangeParameters.get(5)
                ));
    }
}
