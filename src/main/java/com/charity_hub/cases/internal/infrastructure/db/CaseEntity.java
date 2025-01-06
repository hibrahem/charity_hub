package com.charity_hub.cases.internal.infrastructure.db;

import com.charity_hub.cases.internal.application.queries.GetAllCases.GetCasesQueryResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record CaseEntity(
        int code,
        String title,
        String description,
        int goal,
        int collected,
        int status,
        boolean acceptZakat,
        long creationDate,
        long lastUpdated,
        List<String> tags,
        List<String> documents,
        int contributions
) {
    public static final int STATUS_DRAFT = 1;
    public static final int STATUS_OPENED = 2;
    public static final int STATUS_CLOSED = 3;

    public CaseEntity {
        tags = tags != null ? new ArrayList<>(tags) : Collections.emptyList();
        documents = documents != null ? new ArrayList<>(documents) : Collections.emptyList();
    }

    @Override
    public List<String> tags() {
        return Collections.unmodifiableList(tags);
    }

    @Override
    public List<String> documents() {
        return Collections.unmodifiableList(documents);
    }

    public GetCasesQueryResult.Case toQueryResult() {
        return new GetCasesQueryResult.Case(
                code,
                title,
                description,
                goal,
                collected,
                acceptZakat,
                mapStatus(status),
                creationDate,
                lastUpdated,
                documents
        );
    }

    private static String mapStatus(int status) {
        return switch (status) {
            case CaseEntity.STATUS_DRAFT -> "DRAFT";
            case CaseEntity.STATUS_OPENED -> "OPENED";
            default -> "CLOSED";
        };
    }


}