package com.charity_hub.ledger.internal.domain.contracts;

import com.charity_hub.cases.shared.dtos.ContributionConfirmedDTO;
import com.charity_hub.cases.shared.dtos.ContributionPaidDTO;
import com.charity_hub.cases.shared.dtos.ContributionRemindedDTO;
import com.charity_hub.ledger.internal.domain.model.Member;

import java.util.concurrent.CompletableFuture;

public interface INotificationService {
    CompletableFuture<Void> notifyContributionPaid(ContributionPaidDTO contribution);

    CompletableFuture<Void> notifyContributionConfirmed(ContributionConfirmedDTO contribution);

    CompletableFuture<Void> notifyContributorToPay(ContributionRemindedDTO contribution);

    CompletableFuture<Void> notifyNewConnectionAdded(Member member);
}