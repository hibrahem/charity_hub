package com.charity_hub.accounts.shared;

import java.util.UUID;

public record InvitationResponse(String invitedMobileNumber, UUID inviterId) {
}