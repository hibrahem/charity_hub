package com.charity_hub.cases.internal.domain.model.Case;

import com.charity_hub.shared.domain.model.ValueObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record CaseDocuments(List<Document> documents) implements ValueObject {
    
    public CaseDocuments {
        // Defensive copy in constructor
        documents = new ArrayList<>(documents);
    }

    public static CaseDocuments of(List<String> documentUrls) {
        if (documentUrls == null) {
            return new CaseDocuments(new ArrayList<>());
        }
        List<Document> docs = documentUrls.stream()
                .map(Document::new)
                .toList();
        return new CaseDocuments(docs);
    }

    public CaseDocuments update(List<String> documentUrls) {
        return of(documentUrls);
    }

    @Override
    public List<Document> documents() {
        return Collections.unmodifiableList(documents);
    }

    public boolean isEmpty() {
        return documents.isEmpty();
    }

}