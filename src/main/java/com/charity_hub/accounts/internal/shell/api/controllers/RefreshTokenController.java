package com.charity_hub.accounts.internal.shell.api.controllers;

import com.charity_hub.accounts.internal.core.commands.RefreshToken.RefreshToken;
import com.charity_hub.accounts.internal.core.commands.RefreshToken.RefreshTokenHandler;
import com.charity_hub.accounts.internal.shell.api.dtos.BasicResponse;
import com.charity_hub.shared.api.DeferredResults;
import com.charity_hub.shared.auth.AccessTokenPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class RefreshTokenController {
    private final RefreshTokenHandler refreshTokenHandler;

    public RefreshTokenController(RefreshTokenHandler refreshTokenHandler) {
        this.refreshTokenHandler = refreshTokenHandler;
    }

    @PostMapping("/v1/accounts/refresh-token")
    public DeferredResult<ResponseEntity<?>> handle(
            @AuthenticationPrincipal AccessTokenPayload accessTokenPayload
            ){
        RefreshToken command = new RefreshToken(
            accessTokenPayload.getJwtId(),
            accessTokenPayload.getUserId(),
            accessTokenPayload.getDeviceId()
        );
        
        return DeferredResults.from(
            refreshTokenHandler.handle(command)
                .thenApply(accessToken -> ResponseEntity.ok(new BasicResponse(accessToken)))
        );
    }
}
