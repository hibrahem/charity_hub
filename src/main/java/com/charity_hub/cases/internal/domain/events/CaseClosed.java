package com.charity_hub.cases.internal.domain.events;

import com.charity_hub.cases.internal.domain.model.Case.Case;
import com.charity_hub.cases.internal.domain.model.Case.CaseCode;

public record CaseClosed(CaseCode caseCode, String title, int goal, int totalValue, String description) implements CaseEvent {

    public static CaseClosed from(Case case_) {
        return new CaseClosed(
                case_.getCaseCode(),
                case_.getTitle(),
                case_.getGoal(),
                case_.totalContributions(),
                case_.getDescription()
        );
    }
}
