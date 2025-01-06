package com.charity_hub.cases.shared;

import com.charity_hub.cases.shared.dtos.CaseDTO;
import com.charity_hub.cases.shared.dtos.ContributionDTO;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ICasesAPI {
    CompletableFuture<List<ContributionDTO>> getUsersContributions(UUID userId);
    CompletableFuture<List<ContributionDTO>> getNotConfirmedContributions(UUID userId);
    CompletableFuture<List<ContributionDTO>> getUsersContributions(List<UUID> usersIds);
    CompletableFuture<List<CaseDTO>> getCasesByCodes(List<Integer> casesCodes);

}