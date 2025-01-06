package com.charity_hub.cases.internal.domain.model.CaseDetails;

import com.charity_hub.shared.exceptions.BadRequestException;

public record Goal(int value) {
    private static final int MIN_AMOUNT = 100;
    private static final int MAX_AMOUNT = 9999999;

    public Goal {
        if (value < MIN_AMOUNT || value > MAX_AMOUNT) {
            throw new BadRequestException("Goal must be between " + MIN_AMOUNT + " and " + MAX_AMOUNT);
        }
    }
    public static Goal of(int value) {
        return new Goal(value);
    }
}