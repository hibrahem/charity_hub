package com.charity_hub.cases.internal.api.dtos;

import com.charity_hub.shared.abstractions.Request;

import java.util.List;

public record CreateCaseRequest(String title, String description, int goal, boolean publish, boolean acceptZakat,
                                List<String> documents) implements Request {

}