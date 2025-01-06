package com.charity_hub.shared.infrastructure;

import com.charity_hub.shared.domain.ILogger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Logger implements ILogger {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("[Charity-hub - App]");

    @Override
    public void info(String message) {
        logger.debug(message);
    }

    @Override
    public void info(String message, Object... arguments) {
        logger.info(message, arguments);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(String message, Object... arguments) {
        logger.debug(message, arguments);
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void warn(String message, Object... arguments) {
        logger.warn(message, arguments);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Object... arguments) {
        logger.error(message, arguments);
    }
}
