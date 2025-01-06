package com.charity_hub.cases.internal.domain.exceptions;

import com.charity_hub.shared.exceptions.BusinessRuleException;

public class InvalidAmountException extends BusinessRuleException {

    public InvalidAmountException(int value) {
        super(value + " is not a valid amount");
    }
}