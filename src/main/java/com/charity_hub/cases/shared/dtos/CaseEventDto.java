package com.charity_hub.cases.shared.dtos;

public sealed interface CaseEventDto permits
        CaseCreatedDTO,
        CaseOpenedDTO,
        CaseClosedDTO,
        ContributionConfirmedDTO,
        ContributionMadeDTO,
        ContributionPaidDTO,
        ContributionRemindedDTO {
}