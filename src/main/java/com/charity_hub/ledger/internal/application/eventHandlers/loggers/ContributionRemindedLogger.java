package com.charity_hub.ledger.internal.application.eventHandlers.loggers;

import com.charity_hub.cases.shared.dtos.ContributionRemindedDTO;
import com.charity_hub.shared.domain.ILogger;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContributionRemindedLogger {
    private final ILogger logger;

    public ContributionRemindedLogger(ILogger logger) {
        this.logger = logger;
    }

    public void handlerRegistered() {
        logger.info("Registering ContributionRemindedHandler");
    }

    public void processingEvent(ContributionRemindedDTO contribution) {
        logger.info("Processing contribution reminder - Contribution Id: {}, Contributor ID: {}",
                contribution.id(), contribution.contributorId());
    }

    public void notificationSent(UUID id, UUID contributorId) {
        logger.info("Successfully sent reminder notification - Contribution Id: {}, Contributor ID: {}",
                id, contributorId);
    }

    public void notificationFailed(UUID id, UUID contributorId, Exception e) {
        logger.error("Failed to send reminder notification - Contribution Id: {}, Contributor ID: {} - Error: {}",
                id, contributorId, e.getMessage(), e);
    }
} 