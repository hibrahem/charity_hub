package com.charity_hub.cases.internal.infrastructure.queryhandlers;

import com.charity_hub.accounts.shared.AccountDTO;
import com.charity_hub.cases.internal.application.queries.GetCase.GetCaseResponse;
import com.charity_hub.cases.internal.infrastructure.db.CaseEntity;
import com.charity_hub.cases.internal.infrastructure.db.ContributionEntity;
import com.mongodb.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetCaseMapper {

    public GetCaseResponse.CaseDetails toCaseDetails(
            CaseEntity caseEntity,
            List<ContributionEntity> contributions,
            @Nullable
            List<AccountDTO> contributors) {

        return new GetCaseResponse.CaseDetails(
                caseEntity.code(),
                caseEntity.title(),
                caseEntity.description(),
                caseEntity.goal(),
                caseEntity.collected(),
                caseEntity.acceptZakat(),
                mapStatus(caseEntity.status()),
                caseEntity.creationDate(),
                caseEntity.lastUpdated(),
                contributions.stream()
                        .map(contribution -> mapContributions(contribution, contributors))
                        .collect(Collectors.toList()),
                caseEntity.documents()
        );
    }

    private GetCaseResponse.Contribution mapContributions(ContributionEntity contribution, @Nullable List<AccountDTO> contributors) {
        if (contributors != null) {
            return new GetCaseResponse.Contribution(contribution.amount(), contributor(contribution, contributors));
        }
        return new GetCaseResponse.Contribution(contribution.amount(), null);
    }

    private static GetCaseResponse.Contributor contributor(ContributionEntity contribution, List<AccountDTO> contributors) {
        return contributors.stream()
                .filter(account -> contribution.contributorId().equals(account.id()))
                .findFirst()
                .map(GetCaseMapper::contributorOf)
                .orElse(null);
    }

    private static GetCaseResponse.Contributor contributorOf(AccountDTO account) {
        return new GetCaseResponse.Contributor(
                account.id(),
                account.fullName(),
                account.photoUrl()
        );
    }

    private String mapStatus(int status) {
        return switch (status) {
            case CaseEntity.STATUS_DRAFT -> "DRAFT";
            case CaseEntity.STATUS_OPENED -> "OPENED";
            default -> "CLOSED";
        };
    }
}