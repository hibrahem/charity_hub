package com.charity_hub.cases.shared.dtos;

import java.util.UUID;

public record ContributionMadeDTO(
        UUID id,
        UUID contributorId,
        int caseCode,
        int amount
) implements CaseEventDto {
}
