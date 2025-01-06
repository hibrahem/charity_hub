package com.charity_hub.ledger.internal.application.eventHandlers.loggers;

import com.charity_hub.shared.domain.ILogger;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountCreatedEventLogger {
    private final ILogger logger;

    public AccountCreatedEventLogger(ILogger logger) {
        this.logger = logger;
    }

    public void handlerRegistered() {
        logger.info("Registering AccountCreatedEventHandler");
    }

    public void processingAccount(UUID accountId, String mobileNumber) {
        logger.info("Processing account creation - Account ID: {}, Mobile: {}", 
            accountId, maskMobileNumber(mobileNumber));
    }

    public void invitationNotFound(UUID accountId, String mobileNumber) {
        logger.error("Failed to get invitation for account {} with mobileNumber {}", 
            accountId, maskMobileNumber(mobileNumber));
    }

    public void parentMemberNotFound(UUID accountId, UUID inviterId) {
        logger.warn("Parent member not found - Account ID: {}, Inviter ID: {}", 
            accountId, inviterId);
    }

    public void membershipCreated(UUID accountId, UUID parentId) {
        logger.info("Added new membership - Account: {}, Parent: {}", 
            accountId, parentId);
    }

    public void membershipCreationFailed(UUID accountId, UUID parentId, Exception e) {
        logger.error("Failed to create membership - Account: {}, Parent: {} - Error: {}", 
            accountId, parentId, e.getMessage(), e);
    }

    private String maskMobileNumber(String mobileNumber) {
        if (mobileNumber == null) return "null";
        if (mobileNumber.length() <= 4) return "****";
        return "****" + mobileNumber.substring(mobileNumber.length() - 4);
    }
} 