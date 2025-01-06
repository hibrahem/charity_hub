package com.charity_hub.cases.shared.dtos;

import java.util.Date;
import java.util.List;

public record CaseCreatedDTO(
        int caseCode,
        String title,
        String description,
        int goal,
        boolean acceptZakat,
        List<String> tags,
        List<String> documents,
        Date creationDate
) implements CaseEventDto {
}
