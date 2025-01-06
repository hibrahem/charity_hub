package com.charity_hub.accounts.internal.shell.api.controllers;

import com.charity_hub.accounts.internal.core.commands.InviteAccount.InvitationAccount;
import com.charity_hub.accounts.internal.core.commands.InviteAccount.InviteAccountHandler;
import com.charity_hub.accounts.internal.shell.api.dtos.InviteUserRequest;
import com.charity_hub.shared.api.DeferredResults;
import com.charity_hub.shared.auth.AccessTokenPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class InviteUserController {
    private final InviteAccountHandler inviteAccountHandler;

    public InviteUserController(InviteAccountHandler inviteAccountHandler) {
        this.inviteAccountHandler = inviteAccountHandler;
    }

    @PostMapping("/v1/accounts/invite")
    public DeferredResult<ResponseEntity<?>> handle(
            @RequestBody InviteUserRequest inviteUserRequest,
            @AuthenticationPrincipal AccessTokenPayload accessTokenPayload
    ) {
        return DeferredResults.from(inviteAccountHandler.handle(new InvitationAccount(inviteUserRequest.mobileNumber(), accessTokenPayload.getUserId())
        ).thenApply(ResponseEntity::ok));
    }
}