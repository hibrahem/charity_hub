package com.charity_hub.accounts.internal.core.events;

import com.charity_hub.accounts.internal.core.model.account.Account;
import com.charity_hub.accounts.internal.core.model.account.AccountId;
import com.charity_hub.accounts.internal.core.model.device.Device;
import com.charity_hub.accounts.internal.core.model.device.DeviceId;
import com.charity_hub.accounts.internal.core.model.device.DeviceType;
import com.charity_hub.accounts.internal.core.model.device.FCMToken;

public record AccountAuthenticated(AccountId id, DeviceId deviceId, DeviceType deviceType,
                                   FCMToken deviceFCMToken) implements AccountEvent {

    public static AccountAuthenticated from(Account account, Device device) {
        return new AccountAuthenticated(
                account.getId(),
                device.getDeviceId(),
                device.getDeviceType(),
                device.getFcmToken()
        );
    }
}