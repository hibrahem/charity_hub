package com.charity_hub.cases.internal.application.queries.GetDraftCases;

import java.util.ArrayList;
import java.util.List;

public record GetDraftCasesResponse(List<DraftCase> cases) {

    public record DraftCase(
            int code,
            String title,
            String description,
            int goal,
            long creationDate,
            long lastUpdated,
            List<String> documents
    ) {
        public DraftCase(
                int code,
                String title,
                String description,
                int goal,
                long creationDate,
                long lastUpdated,
                List<String> documents
        ) {
            this.code = code;
            this.title = title;
            this.description = description;
            this.goal = goal;
            this.creationDate = creationDate;
            this.lastUpdated = lastUpdated;
            this.documents = documents != null ? documents : new ArrayList<>();
        }

    }
}
