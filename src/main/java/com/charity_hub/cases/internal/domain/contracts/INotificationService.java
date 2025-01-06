package com.charity_hub.cases.internal.domain.contracts;

import com.charity_hub.cases.shared.dtos.CaseClosedDTO;
import com.charity_hub.cases.shared.dtos.CaseOpenedDTO;
import com.charity_hub.cases.shared.dtos.ContributionMadeDTO;

import java.util.concurrent.CompletableFuture;

public interface INotificationService {
    CompletableFuture<Void> subscribeAccountToCaseUpdates(String token);
    
    CompletableFuture<Void> notifyCaseOpened(CaseOpenedDTO case_);
    
    CompletableFuture<Void> notifyCaseClosed(CaseClosedDTO case_);
    
    CompletableFuture<Void> notifyContributionMade(ContributionMadeDTO contribution);
}