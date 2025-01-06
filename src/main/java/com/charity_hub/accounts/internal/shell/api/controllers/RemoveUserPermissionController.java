package com.charity_hub.accounts.internal.shell.api.controllers;

import com.charity_hub.accounts.internal.core.commands.ChangePermission.ChangePermission;
import com.charity_hub.accounts.internal.core.commands.ChangePermission.ChangePermissionHandler;
import com.charity_hub.accounts.internal.shell.api.dtos.ChangePermissionRequest;
import com.charity_hub.shared.api.DeferredResults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

@RestController
public class RemoveUserPermissionController {
    private final ChangePermissionHandler changePermissionHandler;

    public RemoveUserPermissionController(ChangePermissionHandler changePermissionHandler) {
        this.changePermissionHandler = changePermissionHandler;
    }

    @PostMapping("/v1/accounts/{userId}/remove-permission")
    @PreAuthorize("hasAnyAuthority('FULL_ACCESS')")
    public DeferredResult<ResponseEntity<?>> handle(
            @PathVariable UUID userId,
            @RequestBody ChangePermissionRequest request
    ) {
        return DeferredResults.from(changePermissionHandler.handle(
                new ChangePermission(userId, request.permission(), false)
        ).thenApply(ResponseEntity::ok));
    }
}