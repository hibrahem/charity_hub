package com.charity_hub.cases.internal.domain.model.Case;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record NewCaseProbs(
        int caseCode,
        String title,
        String description,
        int goal,
        Status status,
        boolean acceptZakat,
        List<String> documents
) {
    public NewCaseProbs {
        documents = documents != null ? new ArrayList<>(documents) : null;
    }

    @Override
    public List<String> documents() {
        return documents != null ? Collections.unmodifiableList(documents) : null;
    }
}
