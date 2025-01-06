package com.charity_hub.ledger.internal.application.eventHandlers.loggers;

import com.charity_hub.cases.shared.dtos.ContributionPaidDTO;
import com.charity_hub.shared.domain.ILogger;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContributionPaidLogger {
    private final ILogger logger;

    public ContributionPaidLogger(ILogger logger) {
        this.logger = logger;
    }

    public void handlerRegistered() {
        logger.info("Registering ContributionPaidHandler");
    }

    public void processingEvent(ContributionPaidDTO contribution) {
        logger.info("Processing contribution payment - Contribution Id: {}, Contributor ID: {}",
                contribution.id(), contribution.contributorId());
    }

    public void notificationSent(UUID id, UUID contributorId) {
        logger.info("Successfully sent payment notification - Contribution Id: {}, Contributor ID: {}",
                id, contributorId);
    }

    public void notificationFailed(UUID id, UUID contributorId, Exception e) {
        logger.error("Failed to send payment notification - Contribution Id: {}, Contributor ID: {} - Error: {}",
                id, contributorId, e.getMessage(), e);
    }
} 