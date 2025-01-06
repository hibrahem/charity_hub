package com.charity_hub.cases.internal.api.controllers;

import com.charity_hub.cases.internal.application.queries.GetDraftCases.GetDraftCases;
import com.charity_hub.cases.internal.application.queries.GetDraftCases.GetDraftCasesHandler;
import com.charity_hub.shared.api.DeferredResults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


@RestController
public class GetDraftCasesController {

    private final GetDraftCasesHandler getDraftCasesHandler;

    public GetDraftCasesController(GetDraftCasesHandler getDraftCasesHandler) {
        this.getDraftCasesHandler = getDraftCasesHandler;
    }

    @GetMapping("/v1/draft-cases")
    public DeferredResult<ResponseEntity<?>> handle() {
        return DeferredResults.from(getDraftCasesHandler.handle(new GetDraftCases())
                .thenApply(ResponseEntity::ok));
    }
}