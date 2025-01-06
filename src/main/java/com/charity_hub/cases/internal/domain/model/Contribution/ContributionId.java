package com.charity_hub.cases.internal.domain.model.Contribution;

import com.charity_hub.shared.domain.model.ValueObject;

import java.util.UUID;

public record ContributionId(UUID value) implements ValueObject {

    public static ContributionId generate() {
        return new ContributionId(UUID.randomUUID());
    }

}