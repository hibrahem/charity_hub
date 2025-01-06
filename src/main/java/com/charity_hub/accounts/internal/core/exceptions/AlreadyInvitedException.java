package com.charity_hub.accounts.internal.core.exceptions;

import com.charity_hub.shared.exceptions.BusinessRuleException;

public class AlreadyInvitedException extends BusinessRuleException {
    public AlreadyInvitedException(String message) {
        super(message);
    }
}