package com.charity_hub.accounts.shared;

import java.util.List;

public record AccountDTO(String id,
                         String mobileNumber,
                         String fullName,
                         String photoUrl,
                         List<String> devicesTokens) {
}