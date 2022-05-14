package sdarm.scrape.util;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import sdarm.records.SdarmLesson;
import sdarm.records.content.SdarmContent;
import sdarm.records.meta.SdarmLessonDate;
import sdarm.records.meta.SdarmMeta;
import sdarm.records.meta.SdarmSuggestedReading;

import javax.sql.rowset.serial.SerialArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SdarmDocumentParser {

    public static SdarmLesson parseLesson(Elements lesson){
        SdarmMeta sdarmMeta = parseSdarmMeta(lesson.select("div.sbl_lesson_header"));

        return new SdarmLesson(null, null);
    }

    private static SdarmMeta parseSdarmMeta(Elements lessonHeader){
        String sblTitle = lessonHeader.select("p.sbl_lesson_title").text().trim();
        String metaDateString = lessonHeader.select("span.sbl_sabbath").text().trim();
        String[] metaDate = metaDateString.split(",");

        int year = Integer.parseInt(metaDate[2].trim());
        String month = metaDate[1].split(" ")[1].trim();
        int day = Integer.parseInt(metaDate[1].split(" ")[2].trim());

        return new SdarmMeta(
                sblTitle,
                new SdarmLessonDate(
                        year,
                        month,
                        day,
                        metaDateString),
                Integer.parseInt(lessonHeader.select("span.sbl_lesson").text()),
                parseSuggestedReading(lessonHeader));
    }

    private static List<SdarmSuggestedReading> parseSuggestedReading(Elements lessonHeader) {
        Elements suggestedReadings = lessonHeader.select("td.sbl_reading").first().children();
        Elements nextSuggestedReading = null;
        ArrayList<SdarmSuggestedReading> sdarmSuggestedReadings = new ArrayList<>();

        while ((nextSuggestedReading = suggestedReadings.next()).hasText()){
            String book = nextSuggestedReading.select("td.sbl_reading").text();
            String pages = nextSuggestedReading.select("");
        }


        return sdarmSuggestedReadings;
    }

    private static SdarmContent parseSdarmContent(Elements content){
        return new SdarmContent(

        );
    }
}
