package com.charity_hub.ledger.internal.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public record Member(MemberId memberId, MemberId parent, List<MemberId> ancestors, List<MemberId> children) {

    public static Member newMember(Member parent, UUID memberId) {
        List<MemberId> newAncestors = new ArrayList<>(parent.ancestors());
        newAncestors.add(parent.memberId());

        return new Member(
                new MemberId(memberId),
                parent.memberId(),
                newAncestors,
                Collections.emptyList()
        );
    }

    public List<String> ancestorsIds() {
        return ancestors().stream()
                .map(memberId -> memberId.value().toString())
                .toList();
    }

    public String parentId() {
        return parent().value().toString();
    }

    public List<String> childrenIds() {
        return children().stream()
                .map(memberId -> memberId.value().toString())
                .toList();
    }

    public String memberIdValue() {
        return memberId().value().toString();
    }

    @Override
    public List<MemberId> ancestors() {
        return Collections.unmodifiableList(ancestors);
    }

    @Override
    public List<MemberId> children() {
        return Collections.unmodifiableList(children);
    }
}