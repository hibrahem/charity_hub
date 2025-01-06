package com.charity_hub.accounts.internal.core.queriers;

import java.util.List;

public record GetConnectionResponse(List<Account> connections) {
}