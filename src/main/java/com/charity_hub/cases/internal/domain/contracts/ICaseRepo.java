package com.charity_hub.cases.internal.domain.contracts;

import com.charity_hub.cases.internal.domain.model.Case.Case;
import com.charity_hub.cases.internal.domain.model.Case.CaseCode;
import com.charity_hub.cases.internal.domain.model.Contribution.Contribution;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ICaseRepo {
    CompletableFuture<Integer> nextCaseCode();
    
    CompletableFuture<Case> getByCode(CaseCode caseCode);
    
    CompletableFuture<Void> save(Case case_);
    
    CompletableFuture<Void> delete(CaseCode caseCode);
    
    CompletableFuture<Void> save(Contribution contribution);
    
    CompletableFuture<Contribution> getContributionById(UUID id);
}