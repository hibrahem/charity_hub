package com.charity_hub.cases.internal.application.eventHandlers.loggers;

import com.charity_hub.cases.shared.dtos.CaseClosedDTO;
import com.charity_hub.shared.domain.ILogger;
import org.springframework.stereotype.Component;

@Component
public class CaseClosedLogger {
    private final ILogger logger;

    public CaseClosedLogger(ILogger logger) {
        this.logger = logger;
    }

    public void handlerRegistered() {
        logger.info("Registering CaseClosedHandler");
    }

    public void processingEvent(CaseClosedDTO case_) {
        logger.info("Processing CaseClosedEvent - Case Code: {}, Goal: {}, Total: {}", 
            case_.caseCode(), case_.goal(), case_.contributionsTotal());
    }

    public void notificationSent(int caseCode) {
        logger.info("Successfully sent notification for case closed - Case Code: {}", 
            caseCode);
    }

    public void notificationFailed(int caseCode, Exception e) {
        logger.error("Failed to send notification for case closed - Case Code: {} - Error: {}",
            caseCode, e.getMessage(), e);
    }
} 