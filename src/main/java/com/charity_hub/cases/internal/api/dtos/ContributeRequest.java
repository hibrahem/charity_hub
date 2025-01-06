package com.charity_hub.cases.internal.api.dtos;

import com.charity_hub.shared.abstractions.Request;

public record ContributeRequest(int amount) implements Request {
}