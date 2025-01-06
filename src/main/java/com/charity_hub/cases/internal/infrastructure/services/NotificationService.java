package com.charity_hub.cases.internal.infrastructure.services;

import com.charity_hub.cases.shared.dtos.CaseClosedDTO;
import com.charity_hub.cases.shared.dtos.CaseOpenedDTO;
import com.charity_hub.cases.shared.dtos.ContributionMadeDTO;
import com.charity_hub.cases.internal.domain.contracts.ICaseRepo;
import com.charity_hub.cases.internal.domain.contracts.INotificationService;
import com.charity_hub.cases.internal.domain.model.Case.Case;
import com.charity_hub.cases.internal.domain.model.Case.CaseCode;
import com.charity_hub.notifications.NotificationApi;
import com.charity_hub.shared.domain.ILogger;
import com.charity_hub.shared.infrastructure.MessageService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component("casesNotificationService")
public class NotificationService implements INotificationService {
    private final NotificationApi notificationApi;
    private final ICaseRepo caseRepo;
    private final ILogger logger;
    private final MessageService messageService;
    private final Random random = new Random();

    public NotificationService(
            NotificationApi notificationApi,
            ICaseRepo caseRepo,
            ILogger logger,
            MessageService messageService
    ) {
        this.notificationApi = notificationApi;
        this.caseRepo = caseRepo;
        this.logger = logger;
        this.messageService = messageService;
    }

    @Override
    public CompletableFuture<Void> subscribeAccountToCaseUpdates(String token) {
        return CompletableFuture.runAsync(() ->
                notificationApi.subscribeToTopic("CaseUpdates", Collections.singletonList(token))
        );
    }

    @SneakyThrows
    @Override
    public CompletableFuture<Void> notifyCaseOpened(CaseOpenedDTO case_) {
        return CompletableFuture.runAsync(() -> {
            var payload = new NotificationPayload(
                    case_.caseCode(),
                    case_.title()
            );

            notificationApi.notifyTopicSubscribers(
                    "CaseUpdates",
                    "caseCreated",
                    payload,
                    messageService.getMessage("notification.case.new.title"),
                    case_.description()
            );
        });
    }

    @SneakyThrows
    @Override
    public CompletableFuture<Void> notifyCaseClosed(CaseClosedDTO case_) {
        return CompletableFuture.runAsync(() -> {
            int collected = case_.contributionsTotal();
            String title;

            if (collected > case_.goal()) {
                title = messageService.getMessage("notification.case.closed.exceeded", collected);
            } else if (collected == case_.goal()) {
                title = messageService.getMessage("notification.case.closed.exact", collected);
            } else {
                title = messageService.getMessage("notification.case.closed.incomplete");
            }

            var payload = new NotificationPayload(
                    case_.caseCode(),
                    case_.title()
            );

            notificationApi.notifyTopicSubscribers(
                    "CaseUpdates",
                    "caseClosed",
                    payload,
                    title,
                    messageService.getMessage("notification.case.closed.body")
            );
        });
    }

    @SneakyThrows
    @Override
    public CompletableFuture<Void> notifyContributionMade(ContributionMadeDTO contribution) {
        return CompletableFuture.runAsync(() -> {
            Case case_ = caseRepo.getByCode(new CaseCode(contribution.caseCode()))
                    .join();

            if (case_ == null) {
                logger.info("case not found when trying to notify a Contribution");
                return;
            }

            String title = case_.getContributions().size() == 1 ?
                    messageService.getMessage("notification.contribution.first", contribution.amount()) :
                    messageService.getMessage("notification.contribution.additional", contribution.amount());

            String[] messages = messageService.getMessage("notification.contribution.messages").split(",");
            String randomMessage = messages[random.nextInt(messages.length)];

            var payload = new ContributionNotificationPayload(
                    case_.getId().value(),
                    case_.getTitle(),
                    contribution.amount()
            );

            notificationApi.notifyTopicSubscribers(
                    "CaseUpdates",
                    "contributionMade",
                    payload,
                    title,
                    randomMessage
            );
        });
    }

    private record NotificationPayload(
            int caseCode,
            String caseTitle
    ) {
    }

    private record ContributionNotificationPayload(
            int caseCode,
            String caseTitle,
            int amount
    ) {
    }
}