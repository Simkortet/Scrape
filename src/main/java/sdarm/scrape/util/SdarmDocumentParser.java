package sdarm.scrape.util;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sdarm.records.SdarmLesson;
import sdarm.records.content.SdarmContent;
import sdarm.records.meta.SdarmLessonDate;
import sdarm.records.meta.SdarmMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SdarmDocumentParser {

    public static SdarmLesson parseLesson(Elements lesson){
        SdarmMeta sdarmMeta = parseSdarmMeta(lesson.select("div.sbl_lesson_header"));
        //TODO: Implement me
        return new SdarmLesson(null, null);
    }

    private static SdarmMeta parseSdarmMeta(Elements lessonHeader){
        String sblTitle = lessonHeader.select("p.sbl_lesson_title").text().trim();
        String sblSabbath = lessonHeader.select("span.sbl_sabbath").text().trim();

        // Example dayMonthDateYear value: ["Sabbath", "May 14", "2022"]
        String[] dayMonthDateYear = sblSabbath.split(",");

        String month = dayMonthDateYear[1].split(" ")[1].trim();
        int day = Integer.parseInt(dayMonthDateYear[1].split(" ")[2].trim());
        int year = Integer.parseInt(dayMonthDateYear[2].trim());

        return new SdarmMeta(
                sblTitle,
                new SdarmLessonDate(
                        year,
                        month,
                        day,
                        sblSabbath),
                Integer.parseInt(lessonHeader.select("span.sbl_lesson").text().split(" ")[1].trim()),
                parseSuggestedReadings(lessonHeader));
    }

    private static List<String> parseSuggestedReadings(Elements lessonHeader) {
        Element suggestedReadingsElement = lessonHeader.select("td.sbl_reading").first();
        if (suggestedReadingsElement.hasText()){
            return Arrays.stream(suggestedReadingsElement.text().split(";")).toList();
        } else {
            return Collections.emptyList();
        }
    }

    private static SdarmContent parseSdarmContent(Elements content){
        //TODO: implement
        throw new RuntimeException("SdarmContentParser not implemented");
    }
}
