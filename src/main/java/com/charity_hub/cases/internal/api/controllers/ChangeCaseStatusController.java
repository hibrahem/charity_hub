package com.charity_hub.cases.internal.api.controllers;

import com.charity_hub.cases.internal.application.commands.ChangeCaseStatus.ChangeCaseStatus;
import com.charity_hub.cases.internal.application.commands.ChangeCaseStatus.ChangeCaseStatusHandler;
import com.charity_hub.shared.api.DeferredResults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class ChangeCaseStatusController {

    private final ChangeCaseStatusHandler changeCaseStatusHandler;

    public ChangeCaseStatusController(ChangeCaseStatusHandler changeCaseStatusHandler) {
        this.changeCaseStatusHandler = changeCaseStatusHandler;
    }

    @PostMapping("/v1/cases/{caseCode}/open")
    @PreAuthorize("hasAnyAuthority('CREATE_CASES', 'FULL_ACCESS')")
    public DeferredResult<ResponseEntity<?>> open(@PathVariable int caseCode) {
        return DeferredResults.from(changeCaseStatusHandler.handle(new ChangeCaseStatus(caseCode, true))
                .thenApply(ResponseEntity::ok));
    }

    @PostMapping("/v1/cases/{caseCode}/close")
    @PreAuthorize("hasAnyAuthority('CREATE_CASES', 'FULL_ACCESS')")
    public DeferredResult<ResponseEntity<?>> close(@PathVariable int caseCode) {
        return DeferredResults.from(changeCaseStatusHandler.handle(new ChangeCaseStatus(caseCode, false))
                .thenApply(ResponseEntity::ok));
    }
}