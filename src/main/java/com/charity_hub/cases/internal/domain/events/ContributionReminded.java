package com.charity_hub.cases.internal.domain.events;

import com.charity_hub.cases.internal.domain.model.Contribution.Contribution;
import com.charity_hub.cases.internal.domain.model.Contribution.ContributionId;

import java.util.UUID;

public record ContributionReminded(ContributionId id, UUID contributorId) implements CaseEvent {

    public static ContributionReminded from(Contribution contribution) {
        return new ContributionReminded(
                contribution.getId(),
                contribution.getContributorId()
        );
    }

}