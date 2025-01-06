package com.charity_hub.cases.internal.application.queries.GetAllCases;

import java.util.Collections;
import java.util.List;

public record GetCasesQueryResult(List<Case> cases, int count) {

    public record Case(
            int code,
            String title,
            String description,
            int goal,
            int collected,
            boolean acceptZakat,
            String status,
            long creationDate,
            long lastUpdated,
            List<String> documents
    ) {
        public Case {
            documents = documents != null ? documents : Collections.emptyList();
        }
    }
}
