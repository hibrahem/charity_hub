package com.charity_hub.accounts.internal.core.model.invitation;

import com.charity_hub.accounts.internal.core.model.account.MobileNumber;

import java.util.UUID;

public record Invitation(MobileNumber invitedMobileNumber, UUID inviterId) {
    public static Invitation of(String invitedMobileNumber, UUID inviterId) {
        return new Invitation(
                MobileNumber.create(invitedMobileNumber),
                inviterId
        );
    }
}