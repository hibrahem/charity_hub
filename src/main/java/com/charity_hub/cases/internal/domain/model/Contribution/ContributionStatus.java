package com.charity_hub.cases.internal.domain.model.Contribution;

public enum ContributionStatus {
    PLEDGED,
    PAID,
    CONFIRMED;

    public static ContributionStatus fromString(String status) {
        return valueOf(status);
    }

    boolean isConfirmed() {
        return this != PAID;
    }

    boolean isNotPledged() {
        return this != PLEDGED;
    }
}