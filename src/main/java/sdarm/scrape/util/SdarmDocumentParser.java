package sdarm.scrape.util;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sdarm.records.SdarmLesson;
import sdarm.records.content.*;
import sdarm.records.meta.SdarmLessonDate;
import sdarm.records.meta.SdarmMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SdarmDocumentParser {

    public static SdarmLesson parseLesson(Elements lesson) {
        SdarmMeta sdarmMeta = parseSdarmMeta(lesson.select("div.sbl_lesson_header"));
        SdarmContent sdarmContent = parseSdarmContent(lesson.select("div#lessons"));
        return new SdarmLesson(sdarmMeta, sdarmContent);
    }

    private static SdarmMeta parseSdarmMeta(Elements lessonHeader) {
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
        return suggestedReadingsElement != null ?
                Arrays.stream(suggestedReadingsElement.text().split(";")).toList() : Collections.emptyList();
    }

    private static SdarmContent parseSdarmContent(Elements contentWrapper) {
        return new SdarmContent(
                List.of(parseSabbathSection(contentWrapper),
                        parseSundaySection(contentWrapper),
                        parseMondaySection(contentWrapper),
                        parseTuesdaySection(contentWrapper),
                        parseWednesdaySection(contentWrapper),
                        parseThursdaySection(contentWrapper),
                        parseFridaySection(contentWrapper))
        );
    }

    private static SdarmSection parseSabbathSection(Elements contentWrapper) {
        return new SdarmSection(
                "Sabbath",
                null,
                null,
                parseSabbathQuestionComments(contentWrapper)
        );
    }

    private static List<SdarmQuestionComment> parseSabbathQuestionComments(Elements contentWrapper) {
        ArrayList<SdarmQuestionComment> questionComments = new ArrayList<>();
        String keyText = null;
        String keyTextSource = null;

        Element keyTextElement = contentWrapper.select("key_text").first();
        if (keyTextElement != null) {
            keyText = keyTextElement.text().trim();
            keyTextSource = keyText.substring(keyText.lastIndexOf("("), keyText.length() - 1);
            keyText = keyText.substring(0, keyText.lastIndexOf("("));
        }

        Element commentElement = contentWrapper.select("key_note").first();
        String comment = commentElement != null ? commentElement.text() : null;
        String commentReference = comment != null ? comment.substring(comment.lastIndexOf("—"), comment.length() - 1) : null;
        comment = comment != null ? comment.substring(0, comment.lastIndexOf("—")) : null;

        questionComments.add(new SdarmQuestionComment(
                new SdarmQuestion(
                        null,
                        keyText,
                        keyTextSource != null ? Arrays.stream(keyTextSource.split(";"))
                                .map(SdarmVerse::new)
                                .toList() : null
                ),
                new SdarmComment(
                        comment,
                        new SdarmCitation(commentReference)
                )
        ));

        return questionComments;
    }

    private static SdarmSection parseSundaySection(Elements contentWrapper) {
        throw new RuntimeException("Not implemented");
    }

    private static SdarmSection parseMondaySection(Elements contentWrapper) {
        throw new RuntimeException("Not implemented");
    }

    private static SdarmSection parseTuesdaySection(Elements contentWrapper) {
        throw new RuntimeException("Not implemented");
    }

    private static SdarmSection parseWednesdaySection(Elements contentWrapper) {
        throw new RuntimeException("Not implemented");
    }

    private static SdarmSection parseThursdaySection(Elements contentWrapper) {
        throw new RuntimeException("Not implemented");
    }

    private static SdarmSection parseFridaySection(Elements contentWrapper) {
        throw new RuntimeException("Not implemented");
    }
}
