package com.charity_hub.accounts.shared;

import java.util.List;
import java.util.UUID;

public sealed interface AccountEventDto
        permits AccountEventDto.AccountAuthenticated, AccountEventDto.AccountBlocked, AccountEventDto.AccountCreatedDTO, AccountEventDto.AccountUnBlockedDTO, AccountEventDto.BasicInfoUpdatedDTO, AccountEventDto.FCMTokenUpdatedDTO, AccountEventDto.PermissionAddedDTO, AccountEventDto.PermissionRemovedDTO {

    record AccountBlocked(UUID id) implements AccountEventDto {
    }

    record AccountAuthenticated(
            UUID id,
            String deviceId,
            String deviceType,
            String deviceFCMToken
    ) implements AccountEventDto {
    }

    record AccountCreatedDTO(UUID id, String mobileNumber) implements AccountEventDto {
    }

    record AccountUnBlockedDTO(UUID id) implements AccountEventDto {
    }

    record BasicInfoUpdatedDTO(
            UUID id,
            String deviceId,
            String deviceType,
            String deviceFCMToken
    ) implements AccountEventDto {
    }

    record FCMTokenUpdatedDTO(
            String deviceId,
            String deviceType,
            String deviceFCMToken
    ) implements AccountEventDto {
    }

    record PermissionAddedDTO(UUID id, List<String> permissions) implements AccountEventDto {
    }

    record PermissionRemovedDTO(UUID id, List<String> permissions) implements AccountEventDto {
    }
}