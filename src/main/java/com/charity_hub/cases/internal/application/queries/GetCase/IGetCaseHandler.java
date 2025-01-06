package com.charity_hub.cases.internal.application.queries.GetCase;

import java.util.concurrent.CompletableFuture;

public interface IGetCaseHandler {
    CompletableFuture<GetCaseResponse> handle(GetCaseQuery query);
}
