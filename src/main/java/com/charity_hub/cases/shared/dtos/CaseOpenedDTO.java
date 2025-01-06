package com.charity_hub.cases.shared.dtos;

public record CaseOpenedDTO(
        int caseCode,
        String title,
        String description
) implements CaseEventDto {
}
