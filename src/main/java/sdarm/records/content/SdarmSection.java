package sdarm.records.content;

import java.util.List;

public record SdarmSection(SdarmSectionDate sectionDate, String sectionTitle, List<SdarmQuestionComment> sdarmQuestion) {}
