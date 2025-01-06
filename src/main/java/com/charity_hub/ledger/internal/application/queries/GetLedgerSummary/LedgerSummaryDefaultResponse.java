package com.charity_hub.ledger.internal.application.queries.GetLedgerSummary;

import java.util.List;

public record LedgerSummaryDefaultResponse(
        int confirmed,
        int pledged,
        int paid,
        List<ConnectionLedger> connectionsLedger
) {
    public record ConnectionLedger(
            String uuid,
            String name,
            String photoUrl,
            int pledged,
            int paid,
            int confirmed
    ) {
    }
}
