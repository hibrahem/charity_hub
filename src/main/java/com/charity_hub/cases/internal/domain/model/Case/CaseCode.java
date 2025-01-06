package com.charity_hub.cases.internal.domain.model.Case;

import com.charity_hub.shared.domain.model.ValueObject;

public record CaseCode(int value) implements ValueObject {
    public CaseCode {
        if (value <= 0) {
            throw new IllegalArgumentException("Code must be greater than 0");
        }
    }
}