package com.charity_hub.accounts.internal.core.commands.RegisterNotificationToken;

import com.charity_hub.accounts.internal.core.contracts.IAccountRepo;
import com.charity_hub.shared.abstractions.CommandHandler;
import com.charity_hub.shared.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class RegisterNotificationTokenHandler extends CommandHandler<RegisterNotificationToken, Void> {
    private final IAccountRepo accountRepo;

    public RegisterNotificationTokenHandler(IAccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public CompletableFuture<Void> handle(
            RegisterNotificationToken command
    ) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                var identity = accountRepo.getById(command.userId()).join();
                if (identity == null) {
                    throw new NotFoundException("User with Id " + command.userId() + " not found");
                }

                identity.registerFCMToken(
                        command.deviceId(),
                        command.fcmToken()
                );

                accountRepo.save(identity);
                return null;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}