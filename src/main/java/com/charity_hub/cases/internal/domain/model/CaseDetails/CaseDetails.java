package com.charity_hub.cases.internal.domain.model.CaseDetails;

import com.charity_hub.shared.domain.model.ValueObject;

import java.util.List;
import java.util.Objects;

public class CaseDetails implements ValueObject {
    private final Title title;
    private final Description description;
    private final Goal goal;
    private final boolean acceptZakat;
    private final Tags tags;

    private CaseDetails(
            Title title,
            Description description,
            Goal goal,
            boolean acceptZakat,
            Tags tags
    ) {
        this.title = title;
        this.description = description;
        this.goal = goal;
        this.acceptZakat = acceptZakat;
        this.tags = tags;
    }

    public static CaseDetails of(
            String title,
            String description,
            int goal,
            boolean acceptZakat,
            List<String> tags
    ) {
        return new CaseDetails(
                new Title(title),
                Description.create(description),
                Goal.of(goal),
                acceptZakat,
                Tags.of(tags)
        );
    }

    public CaseDetails update(
            String title,
            String description,
            int goal,
            boolean acceptZakat
    ) {
        return new CaseDetails(
                new Title(title),
                Description.create(description),
                Goal.of(goal),
                acceptZakat,
                this.tags
        );
    }

    public CaseDetails updateTags(List<String> tags) {
        return new CaseDetails(
                this.title,
                this.description,
                this.goal,
                this.acceptZakat,
                Tags.of(tags)
        );
    }

    // Value Object getters
    public String getTitle() {
        return title.value();
    }

    public String getDescription() {
        return description.value();
    }

    public int getGoal() {
        return goal.value();
    }

    public boolean isAcceptZakat() {
        return acceptZakat;
    }

    public List<Tag> getTags() {
        return tags.values();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        CaseDetails that = (CaseDetails) o;
        return acceptZakat == that.acceptZakat &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(goal, that.goal) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, goal, acceptZakat, tags);
    }

    @Override
    public String toString() {
        return "CaseDetails{" +
                "title=" + title +
                ", description=" + description +
                ", goal=" + goal +
                ", acceptZakat=" + acceptZakat +
                ", tags=" + tags +
                '}';
    }
} 