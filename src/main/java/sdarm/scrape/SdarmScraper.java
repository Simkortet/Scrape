package sdarm.scrape;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sdarm.records.SdarmLessonScrapeRange;

import java.util.ArrayList;
import java.util.List;

public class SdarmScraper {

    private static final String baseUrlEng = "https://sdarm.org/publications/periodicals/sbl/en/";

    public static void start(SdarmLessonScrapeRange lessonRange){
        List<String> urlsToScrape = getUrlsToScrape(lessonRange);
        List<Document> lessonNodes = getSdarmDocuments(urlsToScrape);


    }

    private static List<Document> getSdarmDocuments(List<String> urlsToScrape) {
        List<Document> sdarmDocuments = new ArrayList<>();

        for (String url : urlsToScrape){
            sdarmDocuments.add(Jsoup.parse(url));
        }
        return sdarmDocuments;
    }

    private static List<String> getUrlsToScrape(SdarmLessonScrapeRange lessonRange){
        List<String> urlsToScrape = new ArrayList<>();

        for (int year = lessonRange.startLesson().year(); year < lessonRange.endLesson().year(); year++){
            for (int quarter = lessonRange.startLesson().quarter(); quarter <= lessonRange.endLesson().quarter(); quarter++){
                for (int lessonNumber = lessonRange.startLesson().number(); lessonNumber <= lessonRange.endLesson().number(); lessonNumber++){
                    urlsToScrape.add(baseUrlEng + year + "/" + quarter + "/" + lessonNumber + "/");
                }
            }
        }

        return urlsToScrape;
    }
}
