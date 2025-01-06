package com.charity_hub.ledger.internal.application.eventHandlers.loggers;

import com.charity_hub.cases.shared.dtos.ContributionConfirmedDTO;
import com.charity_hub.shared.domain.ILogger;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContributionConfirmedLogger {
    private final ILogger logger;

    public ContributionConfirmedLogger(ILogger logger) {
        this.logger = logger;
    }

    public void handlerRegistered() {
        logger.info("Registering ContributionConfirmedHandler");
    }

    public void processingEvent(ContributionConfirmedDTO contribution) {
        logger.info("Processing contribution confirmation - Contribution Id: {}, Contributor ID: {}",
                contribution.id(), contribution.contributorId());
    }

    public void notificationSent(UUID id, UUID contributorId) {
        logger.info("Successfully sent confirmation notification - Contribution Id: {}, Contributor ID: {}",
                id, contributorId);
    }

    public void notificationFailed(UUID uuid, UUID contributorId, Exception e) {
        logger.error("Failed to send confirmation notification - Contribution Id: {}, Contributor ID: {} - Error: {}",
                uuid, contributorId, e.getMessage(), e);
    }
} 