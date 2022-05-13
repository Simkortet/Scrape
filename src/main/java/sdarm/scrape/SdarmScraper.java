package sdarm.scrape;

import sdarm.records.meta.SdarmLessonDate;

import java.util.ArrayList;
import java.util.List;

public class SdarmScraper {

    private static final String baseUrlEng = "https://sdarm.org/publications/periodicals/sbl/en/";

    public static void start(){

    }

    private static List<String> getUrlsToScrape(int startLessonNumber, int startLessonYear, int endLessonNumber, int endLessonYear){
        List<String> urlsToScrape = new ArrayList<>();

        for (int year = startLessonYear; year < endLessonYear; year++){
            for (int quarter = 1; quarter <= 4; quarter++){
                for (int lessonNumber = startLessonNumber; lessonNumber <= endLessonNumber; lessonNumber++){
                    urlsToScrape.add(baseUrlEng + year + "/" + quarter + "/" + lessonNumber + "/");
                }
            }
        }

        return urlsToScrape;
    }
}
