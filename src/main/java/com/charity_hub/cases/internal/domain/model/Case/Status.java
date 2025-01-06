package com.charity_hub.cases.internal.domain.model.Case;

public enum Status {
    DRAFT,
    OPENED,
    CLOSED;

    public static Status fromString(String status) {
        return valueOf(status.toUpperCase());
    }
}