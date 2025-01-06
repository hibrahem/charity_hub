package com.charity_hub.ledger.internal.application.queries.GetLedger;

import com.charity_hub.shared.abstractions.Query;

import java.util.UUID;

public record GetLedger(UUID userId) implements Query {
}
