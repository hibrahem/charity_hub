package com.charity_hub.cases.internal.application.queries.GetAllCases;

import java.util.concurrent.CompletableFuture;

public interface IGetAllCasesHandler {
    CompletableFuture<GetCasesQueryResult> handle(GetAllCasesQuery query);
}
