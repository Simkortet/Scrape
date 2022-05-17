package sdarm.records.content;

import java.util.List;

public record SdarmSection(
        String day,
        SdarmSectionDate sectionDate,
        String sectionTitle,
        List<SdarmQuestionComment> questionComment
) {}
