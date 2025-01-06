package com.charity_hub.shared.domain.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot<T extends ValueObject> extends Entity<T> {
    private static final Logger log = LoggerFactory.getLogger(AggregateRoot.class);
    private final List<DomainEvent> occurredEvents = new ArrayList<>();

    protected AggregateRoot(T id) {
        super(id);
    }

    public List<DomainEvent> occurredEvents() {
        List<DomainEvent> events = new ArrayList<>(this.occurredEvents);
        this.occurredEvents.clear();
        log.trace("Return occurred domain events. [numberOfEvents={}]", events.size());
        return events;
    }

    protected void raiseEvent(DomainEvent event) {
        occurredEvents.add(event);
        log.debug("Raised new domain event. [type={}]", event.getClass().getSimpleName());
    }
}