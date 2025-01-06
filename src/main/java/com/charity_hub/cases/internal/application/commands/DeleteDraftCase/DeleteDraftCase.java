package com.charity_hub.cases.internal.application.commands.DeleteDraftCase;

import com.charity_hub.shared.abstractions.Command;

public record DeleteDraftCase(int caseCode) implements Command {
}