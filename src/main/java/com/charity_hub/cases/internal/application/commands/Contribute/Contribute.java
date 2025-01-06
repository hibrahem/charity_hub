package com.charity_hub.cases.internal.application.commands.Contribute;

import com.charity_hub.shared.abstractions.Command;

import java.util.UUID;

public record Contribute(int amount, UUID userId, int caseCode) implements Command {
}