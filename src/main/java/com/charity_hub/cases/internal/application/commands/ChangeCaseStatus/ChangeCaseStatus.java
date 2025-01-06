package com.charity_hub.cases.internal.application.commands.ChangeCaseStatus;

import com.charity_hub.shared.abstractions.Command;

public record ChangeCaseStatus(int caseCode, boolean isActionOpen) implements Command {
}