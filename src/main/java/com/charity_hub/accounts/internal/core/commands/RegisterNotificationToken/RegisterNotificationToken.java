package com.charity_hub.accounts.internal.core.commands.RegisterNotificationToken;

import com.charity_hub.shared.abstractions.Command;

import java.util.UUID;

public record RegisterNotificationToken(String fcmToken, String deviceId, UUID userId) implements Command {
}