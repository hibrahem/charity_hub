package com.charity_hub.cases.internal.application.commands.UpdateCase;

import com.charity_hub.shared.abstractions.Command;

import java.util.List;

public record UpdateCase(int caseCode, String title, String description, int goal, boolean acceptZakat,
                         List<String> documents) implements Command {

}