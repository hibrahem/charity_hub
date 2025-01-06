package com.charity_hub.cases.internal.domain.events;

import com.charity_hub.cases.internal.domain.model.Case.CaseCode;
import com.charity_hub.cases.internal.domain.model.Contribution.Contribution;
import com.charity_hub.cases.internal.domain.model.Contribution.ContributionId;
import com.charity_hub.cases.internal.domain.model.Contribution.MoneyValue;

import java.util.UUID;

public record ContributionMade(ContributionId id, UUID contributorId, CaseCode caseCode,
                               MoneyValue moneyValue) implements CaseEvent {

    public static ContributionMade from(Contribution contribution) {
        return new ContributionMade(
                contribution.getId(),
                contribution.getContributorId(),
                contribution.getCaseId(),
                contribution.getMoneyValue()
        );
    }
}