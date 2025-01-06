package com.charity_hub.ledger.internal.infrastructure.db;

import java.util.List;

public record MemberEntity(String _id, List<String> ancestors, String parent, List<String> children) { }