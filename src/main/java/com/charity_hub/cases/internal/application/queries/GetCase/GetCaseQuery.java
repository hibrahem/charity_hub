package com.charity_hub.cases.internal.application.queries.GetCase;

import com.charity_hub.shared.abstractions.Query;
import com.charity_hub.shared.auth.AccessTokenPayload;

public record GetCaseQuery(int caseCode, AccessTokenPayload accessTokenPayload) implements Query {
}