package com.charity_hub.ledger.internal.application.models;

import java.util.UUID;

public record InvitationResponse(String invitedMobileNumber, UUID inviterId) {
}
