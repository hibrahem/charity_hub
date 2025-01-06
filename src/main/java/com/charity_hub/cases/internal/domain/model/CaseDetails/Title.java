package com.charity_hub.cases.internal.domain.model.CaseDetails;

public record Title(String value) {
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 100;

    public Title {
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    "Title must be between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters"
            );
        }
    }

}