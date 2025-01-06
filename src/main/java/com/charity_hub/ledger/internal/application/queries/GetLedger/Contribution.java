package com.charity_hub.ledger.internal.application.queries.GetLedger;

public record Contribution(String id, String contributorId, int caseCode, String caseName, int amount, String status,
                           long contributionDate) {
}
