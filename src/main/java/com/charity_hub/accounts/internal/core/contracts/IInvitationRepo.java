package com.charity_hub.accounts.internal.core.contracts;

import com.charity_hub.accounts.internal.core.model.invitation.Invitation;

import java.util.concurrent.CompletableFuture;

public interface IInvitationRepo {
    CompletableFuture<Void> save(Invitation invitation);

    CompletableFuture<Invitation> get(String mobileNumber);

    CompletableFuture<Boolean> hasInvitation(String mobileNumber);
}