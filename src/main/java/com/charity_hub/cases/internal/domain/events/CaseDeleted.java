package com.charity_hub.cases.internal.domain.events;

import com.charity_hub.cases.internal.domain.model.Case.Case;

public record CaseDeleted(Case case_) implements CaseEvent {

    public Case getCase() {
        return case_;
    }
}
