package com.charity_hub.accounts.internal.core.commands.RefreshToken;

import com.charity_hub.shared.abstractions.Command;

import java.util.UUID;

public record RefreshToken(String encodedRefreshToken,
                           UUID userId,
                           String deviceId) implements Command {
}