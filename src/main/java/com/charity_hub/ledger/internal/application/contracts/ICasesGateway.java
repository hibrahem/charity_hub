package com.charity_hub.ledger.internal.application.contracts;

import com.charity_hub.cases.shared.dtos.CaseDTO;
import com.charity_hub.cases.shared.dtos.ContributionDTO;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ICasesGateway {
    CompletableFuture<List<ContributionDTO>> getContributions(UUID userId);

    CompletableFuture<List<CaseDTO>> getCasesByIds(List<Integer> casesCodes);

    CompletableFuture<List<ContributionDTO>> getNotConfirmedContributions(UUID userId);

    CompletableFuture<List<ContributionDTO>> getContributions(List<UUID> usersIds);
}
