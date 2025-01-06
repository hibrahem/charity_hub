package com.charity_hub.cases.shared.dtos;

public record CaseClosedDTO(
        int caseCode,
        String title,
        int goal,
        int contributionsTotal
) implements CaseEventDto {
}
