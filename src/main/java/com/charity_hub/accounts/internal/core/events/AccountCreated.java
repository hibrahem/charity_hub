package com.charity_hub.accounts.internal.core.events;

import com.charity_hub.accounts.internal.core.model.account.Account;
import com.charity_hub.accounts.internal.core.model.account.AccountId;
import com.charity_hub.accounts.internal.core.model.account.MobileNumber;

public record AccountCreated(AccountId id, MobileNumber mobileNumber) implements AccountEvent {

    public static AccountCreated from(Account account) {
        return new AccountCreated(
                account.getId(),
                account.getMobileNumber()
        );
    }

}