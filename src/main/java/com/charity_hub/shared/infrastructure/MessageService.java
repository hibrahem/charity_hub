package com.charity_hub.shared.infrastructure;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {
    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code, Object... args) {
        return messageSource.getMessage(
            code, 
            args, 
            LocaleContextHolder.getLocale()
        );
    }

    public String getMessage(String code, Locale locale, Object... args) {
        return messageSource.getMessage(
            code, 
            args, 
            locale
        );
    }
} 