package com.charity_hub.ledger.internal.application.contracts;

import com.charity_hub.ledger.internal.domain.model.Member;
import com.charity_hub.ledger.internal.domain.model.MemberId;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IMembersNetworkRepo {
    CompletableFuture<Member> getById(UUID id);

    CompletableFuture<Void> delete(MemberId id);

    CompletableFuture<Void> save(Member member);
}
