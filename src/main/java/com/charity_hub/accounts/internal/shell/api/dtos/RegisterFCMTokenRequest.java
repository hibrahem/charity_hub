package com.charity_hub.accounts.internal.shell.api.dtos;

import com.charity_hub.shared.abstractions.Request;

public record RegisterFCMTokenRequest(String fcmToken) implements Request {
}
