package com.charity_hub.cases.internal.domain.exceptions;

import com.charity_hub.shared.exceptions.BusinessRuleException;

public class CaseExceptions {
    public static class CannotDeleteCaseException extends BusinessRuleException {
        public CannotDeleteCaseException() {
            super("You can't delete this case");
        }
    }

    public static class CaseAlreadyOpenedException extends BusinessRuleException {
        public CaseAlreadyOpenedException() {
            super("The case is already opened");
        }
    }

    public static class CaseAlreadyClosedException extends BusinessRuleException {
        public CaseAlreadyClosedException() {
            super("The case is already closed");
        }
    }

    public static class CannotContributeException extends BusinessRuleException {
        public CannotContributeException() {
            super("You can't contribute in a closed case!");
        }
    }
} 