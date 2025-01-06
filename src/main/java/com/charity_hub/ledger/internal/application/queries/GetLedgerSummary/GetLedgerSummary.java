package com.charity_hub.ledger.internal.application.queries.GetLedgerSummary;

import com.charity_hub.shared.abstractions.Query;

import java.util.UUID;

public record GetLedgerSummary(UUID userId) implements Query {
}
