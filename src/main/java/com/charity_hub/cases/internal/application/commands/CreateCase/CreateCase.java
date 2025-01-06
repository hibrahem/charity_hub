package com.charity_hub.cases.internal.application.commands.CreateCase;

import com.charity_hub.shared.abstractions.Command;

import java.util.List;

public record CreateCase(String title, String description, int goal, boolean publish, boolean acceptZakat,
                         List<String> documents) implements Command {
}