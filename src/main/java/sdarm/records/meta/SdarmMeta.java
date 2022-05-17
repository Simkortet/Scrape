package sdarm.records.meta;

import java.util.List;

public record SdarmMeta(String title,
                        SdarmLessonDate date,
                        int number,
                        List<String> suggestedReading) {
}
