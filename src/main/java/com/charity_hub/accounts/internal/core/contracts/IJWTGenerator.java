package com.charity_hub.accounts.internal.core.contracts;

import com.charity_hub.accounts.internal.core.model.account.Account;
import com.charity_hub.accounts.internal.core.model.device.Device;

public interface IJWTGenerator {
    String generateAccessToken(Account account, Device device);

    String generateRefreshToken(Account account, Device device);
}