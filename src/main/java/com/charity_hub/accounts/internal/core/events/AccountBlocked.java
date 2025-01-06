package com.charity_hub.accounts.internal.core.events;

import com.charity_hub.accounts.internal.core.model.account.AccountId;

public record AccountBlocked(AccountId id) implements AccountEvent {
}