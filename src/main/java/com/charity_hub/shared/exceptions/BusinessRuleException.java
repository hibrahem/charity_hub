package com.charity_hub.shared.exceptions;

public class BusinessRuleException extends RuntimeException {
    public BusinessRuleException(String description) {
        super(description);
    }
}
