package com.charity_hub.accounts.internal.shell.api.dtos;

public record ChangePermissionRequest(String permission, boolean shouldAdd) {
}