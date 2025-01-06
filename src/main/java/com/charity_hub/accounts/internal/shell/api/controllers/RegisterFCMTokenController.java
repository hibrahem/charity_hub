package com.charity_hub.accounts.internal.shell.api.controllers;

import com.charity_hub.accounts.internal.core.commands.RegisterNotificationToken.RegisterNotificationToken;
import com.charity_hub.accounts.internal.core.commands.RegisterNotificationToken.RegisterNotificationTokenHandler;
import com.charity_hub.accounts.internal.shell.api.dtos.RegisterFCMTokenRequest;
import com.charity_hub.shared.api.DeferredResults;
import com.charity_hub.shared.auth.AccessTokenPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class RegisterFCMTokenController {
    private final RegisterNotificationTokenHandler registerNotificationTokenHandler;

    public RegisterFCMTokenController(RegisterNotificationTokenHandler registerNotificationTokenHandler) {
        this.registerNotificationTokenHandler = registerNotificationTokenHandler;
    }

    @PostMapping("/v1/accounts/register-fcm-token")
    public DeferredResult<ResponseEntity<?>> handle(@RequestBody RegisterFCMTokenRequest request, @AuthenticationPrincipal AccessTokenPayload accessTokenPayload) {
        RegisterNotificationToken command =
                new RegisterNotificationToken(request.fcmToken(),
                        accessTokenPayload.getDeviceId(),
                        accessTokenPayload.getUserId());
        return DeferredResults.from(
                registerNotificationTokenHandler.handle(command)
                        .thenApply(result -> ResponseEntity.status(HttpStatus.CREATED).build()));
    }
}
