package com.charity_hub.accounts.internal.core.commands.InviteAccount;

import com.charity_hub.shared.abstractions.Command;

import java.util.UUID;

public record InvitationAccount(String mobileNumber, UUID inviterId) implements Command {
}