package sdarm.records.content;

import java.util.List;

public record SdarmQuestion(String alphanumeric, String question, List<SdarmVerse> verses) {
}
