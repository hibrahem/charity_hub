package com.charity_hub.accounts.internal.core.queriers;

import com.charity_hub.shared.abstractions.Query;

import java.util.UUID;

public record GetConnectionsQuery(UUID userId) implements Query {
}
