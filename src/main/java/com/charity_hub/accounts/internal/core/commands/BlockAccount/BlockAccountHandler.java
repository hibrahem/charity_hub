package com.charity_hub.accounts.internal.core.commands.BlockAccount;

import com.charity_hub.accounts.internal.core.contracts.IAccountRepo;
import com.charity_hub.shared.abstractions.CommandHandler;
import com.charity_hub.shared.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class BlockAccountHandler extends CommandHandler<BlockAccount, Void> {
    private final IAccountRepo accountRepo;

    public BlockAccountHandler(IAccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public CompletableFuture<Void> handle(BlockAccount command) {
        return CompletableFuture.runAsync(() -> {
            try {
                var identity = accountRepo.getById(UUID.fromString(command.userId())).join();
                if (identity == null) {
                    throw new NotFoundException("User with Id " + command.userId() + " not found");
                }

                if (command.isUnblock()) {
                    identity.unBlock();
                } else {
                    identity.block();
                }

                accountRepo.save(identity);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}