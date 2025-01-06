package com.charity_hub.ledger.internal.application.eventHandlers.AccountCreated;

import java.util.UUID;

public record AccountCreated(UUID id, String mobileNumber){}