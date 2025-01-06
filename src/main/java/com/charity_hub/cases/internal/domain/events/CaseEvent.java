package com.charity_hub.cases.internal.domain.events;

import com.charity_hub.shared.domain.model.DomainEvent;

public sealed interface CaseEvent extends DomainEvent
        permits CaseClosed, CaseDeleted, CaseOpened, CaseUpdated, ContributionConfirmed, ContributionMade, ContributionPaid, ContributionReminded {
}