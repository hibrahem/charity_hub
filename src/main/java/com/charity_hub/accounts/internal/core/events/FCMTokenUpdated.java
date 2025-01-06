package com.charity_hub.accounts.internal.core.events;

import com.charity_hub.accounts.internal.core.model.device.Device;
import com.charity_hub.accounts.internal.core.model.device.DeviceId;
import com.charity_hub.accounts.internal.core.model.device.DeviceType;
import com.charity_hub.accounts.internal.core.model.device.FCMToken;

public record FCMTokenUpdated(DeviceId deviceId, DeviceType deviceType,
                              FCMToken deviceFCMToken) implements AccountEvent {

    public static FCMTokenUpdated from(Device device) {
        return new FCMTokenUpdated(
                device.getDeviceId(),
                device.getDeviceType(),
                device.getFcmToken()
        );
    }

}