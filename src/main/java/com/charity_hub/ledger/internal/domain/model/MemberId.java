package com.charity_hub.ledger.internal.domain.model;

import com.charity_hub.shared.domain.model.ValueObject;

import java.util.UUID;

public record MemberId(UUID value) implements ValueObject {
}