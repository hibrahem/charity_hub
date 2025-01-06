package com.charity_hub.cases.internal.application.loggers;

import com.charity_hub.shared.domain.ILogger;
import org.springframework.stereotype.Component;

@Component
public class FCMTokenLogger {
    private final ILogger logger;

    public FCMTokenLogger(ILogger logger) {
        this.logger = logger;
    }

    public void handlerRegistered() {
        logger.info("Registering FCMTokenUpdatedHandler");
    }

    public void processingToken(String token) {
        logger.info("Processing FCM token update: {}", maskToken(token));
    }

    public void tokenSubscribed(String token) {
        logger.info("Successfully subscribed FCM token to case updates: {}", maskToken(token));
    }

    public void tokenSubscriptionFailed(String token, Exception e) {
        logger.error("Failed to subscribe FCM token to case updates: {} - Error: {}",
                maskToken(token), e.getMessage(), e);
    }

    public void nullTokenReceived() {
        logger.warn("Received null FCM token, skipping subscription");
    }

    // Helper method to mask sensitive token data in logs
    private String maskToken(String token) {
        if (token == null) return "null";
        if (token.length() <= 8) return "***";
        return token.substring(0, 4) + "..." + token.substring(token.length() - 4);
    }
} 