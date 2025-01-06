package com.charity_hub.cases.internal.domain.model.CaseDetails;

import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(includeFieldNames = false)
@EqualsAndHashCode
@Value
public class Tags {
    List<Tag> values;

    public static Tags of(List<String> tags) {
        List<Tag> tagList = tags.stream()
                .map(Tag::create)
                .collect(Collectors.toList());
        return new Tags(tagList);
    }

    public List<Tag> values() {
        return Collections.unmodifiableList(values);
    }
}