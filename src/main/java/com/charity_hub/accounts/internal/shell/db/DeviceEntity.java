package com.charity_hub.accounts.internal.shell.db;


public record DeviceEntity(String deviceId,
                           String deviceType,
                           String refreshToken,
                           String fcmToken,
                           long lastAccessTime) {
}