package com.charity_hub.cases.internal.domain.model.CaseDetails;

import com.charity_hub.shared.exceptions.BadRequestException;


public record Description(String value) {
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 2000;

    public Description {
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new BadRequestException("Description must be between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters");
        }
    }

    public static Description create(String value) {
        return new Description(value);
    }
}