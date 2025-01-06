package com.charity_hub.cases.internal.domain.model.Case;

import com.charity_hub.shared.domain.model.ValueObject;

import static com.charity_hub.cases.internal.domain.exceptions.CaseExceptions.CaseAlreadyClosedException;
import static com.charity_hub.cases.internal.domain.exceptions.CaseExceptions.CaseAlreadyOpenedException;

public record CaseStatus(Status value) implements ValueObject {

    public static CaseStatus of(Status status) {
        return new CaseStatus(status);
    }

    public CaseStatus open() {
        if (isOpened()) {
            throw new CaseAlreadyOpenedException();
        }
        return new CaseStatus(Status.OPENED);
    }

    public CaseStatus close() {
        if (isClosed()) {
            throw new CaseAlreadyClosedException();
        }
        return new CaseStatus(Status.CLOSED);
    }

    public boolean isOpened() {
        return value == Status.OPENED;
    }

    public boolean isClosed() {
        return value == Status.CLOSED;
    }

    public boolean isDraft() {
        return value == Status.DRAFT;
    }
} 