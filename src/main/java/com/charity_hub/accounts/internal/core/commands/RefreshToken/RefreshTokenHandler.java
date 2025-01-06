package com.charity_hub.accounts.internal.core.commands.RefreshToken;

import com.charity_hub.accounts.internal.core.contracts.IAccountRepo;
import com.charity_hub.accounts.internal.core.contracts.IJWTGenerator;
import com.charity_hub.shared.abstractions.CommandHandler;
import com.charity_hub.shared.domain.ILogger;
import com.charity_hub.shared.exceptions.UnAuthorized;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class RefreshTokenHandler extends CommandHandler<RefreshToken, String> {
    private final IAccountRepo accountRepo;
    private final IJWTGenerator jwtGenerator;
    private final ILogger logger;

    public RefreshTokenHandler(IAccountRepo accountRepo, IJWTGenerator jwtGenerator, ILogger logger) {
        this.accountRepo = accountRepo;
        this.jwtGenerator = jwtGenerator;
        this.logger = logger;
    }


    public CompletableFuture<String> handle(RefreshToken command) {
        return CompletableFuture.supplyAsync(() -> {
            logger.info("here " + command.encodedRefreshToken());

            var account = accountRepo.getById(command.userId()).join();
            if (account == null) {
                throw new UnAuthorized("Unauthorized access.");
            }

            String accessToken = account.refreshAccessToken(
                    command.deviceId(),
                    command.encodedRefreshToken(),
                    jwtGenerator
            );

            accountRepo.save(account);
            return accessToken;
        });
    }
}