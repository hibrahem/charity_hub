package com.charity_hub.cases.internal.domain.model.Case;

import com.charity_hub.cases.internal.domain.model.Contribution.Contribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public record CaseProps(
        int code,
        String title,
        String description,
        int goal,
        Status status,
        boolean acceptZakat,
        List<String> tags,
        List<String> documents,
        List<Contribution> contributions,
        Date creationDate,
        Date lastUpdated
) {
    public CaseProps {
        tags = new ArrayList<>(tags);
        documents = new ArrayList<>(documents);
        contributions = new ArrayList<>(contributions);
    }

    public static CaseProps from(NewCaseProbs props) {
        return new CaseProps(
                props.caseCode(),
                props.title(),
                props.description(),
                props.goal(),
                props.status(),
                props.acceptZakat(),
                Collections.emptyList(),
                props.documents() != null ? props.documents() : Collections.emptyList(),
                new ArrayList<>(),
                new Date(),
                new Date()
        );
    }

    @Override
    public List<String> tags() {
        return Collections.unmodifiableList(tags);
    }

    @Override
    public List<String> documents() {
        return Collections.unmodifiableList(documents);
    }

    @Override
    public List<Contribution> contributions() {
        return Collections.unmodifiableList(contributions);
    }

    @Override
    public Date creationDate() {
        return new Date(creationDate.getTime());
    }

    @Override
    public Date lastUpdated() {
        return new Date(lastUpdated.getTime());
    }
}
