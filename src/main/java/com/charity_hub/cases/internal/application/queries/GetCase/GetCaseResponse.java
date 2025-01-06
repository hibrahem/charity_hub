package com.charity_hub.cases.internal.application.queries.GetCase;

import java.util.ArrayList;
import java.util.List;

public class GetCaseResponse {
    private final CaseDetails case_;

    public GetCaseResponse(CaseDetails case_) {
        this.case_ = case_;
    }

    public CaseDetails getCase() {
        return case_;
    }

    public record CaseDetails(
            int code,
            String title,
            String description,
            int goal,
            int collected,
            boolean acceptZakat,
            String status,
            long creationDate,
            long lastUpdated,
            List<Contribution> contributions,
            List<String> documents
    ) {
        public CaseDetails {
            documents = documents != null ? documents : new ArrayList<>();
        }

    }

    public record Contribution(int amount, Contributor contributor) {
    }

    public record Contributor(String id, String fullName, String photoUrl) {
    }
}
