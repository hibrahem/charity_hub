package com.charity_hub.cases.internal.domain.model.Contribution;

import com.charity_hub.cases.internal.domain.model.Case.CaseCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Contributions {
    private final List<Contribution> contributions;

    private Contributions(List<Contribution> contributions) {
        this.contributions = new ArrayList<>(contributions);
    }

    public static Contributions of(List<Contribution> contributions) {
        return new Contributions(contributions);
    }

    public Contribution newContribution(UUID contributorId, int amount, CaseCode caseCode1) {
        Contribution contribution = Contribution.new_(
                contributorId,
                caseCode1.value(),
                amount
        );
        contributions.add(contribution);
        return contribution;
    }

    public int totalValue() {
        return contributions.stream()
                .mapToInt(contribution -> contribution.getMoneyValue().value())
                .sum();
    }

    public int numberOfContributions() {
        return contributions.size();
    }

    public List<Contribution> values() {
        return Collections.unmodifiableList(contributions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contributions that = (Contributions) o;
        return contributions.equals(that.contributions);
    }

    @Override
    public int hashCode() {
        return contributions.hashCode();
    }

    @Override
    public String toString() {
        return "Contributions{" +
                "contributions=" + contributions +
                '}';
    }
}