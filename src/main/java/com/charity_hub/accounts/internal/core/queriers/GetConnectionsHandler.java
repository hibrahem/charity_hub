package com.charity_hub.accounts.internal.core.queriers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.charity_hub.shared.domain.ILogger;
import org.springframework.stereotype.Service;

import com.charity_hub.accounts.internal.core.contracts.IAccountRepo;
import com.charity_hub.accounts.internal.core.model.account.Account;
import com.charity_hub.shared.abstractions.QueryHandler;

@Service
public class GetConnectionsHandler implements QueryHandler<GetConnectionsQuery, List<Account>> {
    private final IAccountRepo accountRepo;
    private final ILogger logger;

    GetConnectionsHandler(IAccountRepo accountRepo, ILogger logger) {
        this.accountRepo = accountRepo;
        this.logger = logger;
    }

    @Override
    public CompletableFuture<List<Account>> handle(GetConnectionsQuery query) {
        return accountRepo.getConnections(query.userId())
                .exceptionally(throwable -> {
                    logger.error("Failed to get connections for user: {}", query.userId(), throwable);
                    throw new RuntimeException("Failed to fetch connections", throwable);
                });
    }
}