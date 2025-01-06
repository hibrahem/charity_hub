package com.charity_hub.accounts.internal.core.commands.Authenticate;

import com.charity_hub.shared.abstractions.Command;

public record Authenticate(String idToken, String deviceId, String deviceType) implements Command {
}