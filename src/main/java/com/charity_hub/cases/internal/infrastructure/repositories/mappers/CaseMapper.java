package com.charity_hub.cases.internal.infrastructure.repositories.mappers;

import com.charity_hub.cases.internal.domain.model.Case.*;
import com.charity_hub.cases.internal.domain.model.CaseDetails.Tag;
import com.charity_hub.cases.internal.infrastructure.db.CaseEntity;
import com.charity_hub.cases.internal.infrastructure.db.ContributionEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CaseMapper {
    private final ContributionMapper contributionMapper;

    public CaseMapper(ContributionMapper contributionMapper) {
        this.contributionMapper = contributionMapper;
    }

    public Case toDomain(CaseEntity entity, List<ContributionEntity> contributionsEntities) {
        try {
            CaseProps caseProps = new CaseProps(
                    entity.code(),
                    entity.title(),
                    entity.description(),
                    entity.goal(),
                    getStatus(entity.status()),
                    entity.acceptZakat(),
                    entity.tags(),
                    entity.documents(),
                    contributionsEntities.stream()
                            .map(contributionMapper::toDomain)
                            .collect(Collectors.toList()),
                    new Date(entity.creationDate()),
                    new Date(entity.lastUpdated())
            );

            return Case.create(caseProps);
        } catch (Exception exc) {
            throw new RuntimeException("Could not map Case from the database - " + exc.getMessage());
        }
    }

    public CaseEntity toDB(Case domain) {
        return new CaseEntity(
                domain.getCaseCode().value(),
                domain.getTitle(),
                domain.getDescription(),
                domain.getGoal(),
                domain.totalContributions(),
                getStatusCode(domain.getStatus()),
                domain.getAcceptZakat(),
                domain.getCreationDate().getTime(),
                domain.getLastUpdated().getTime(),
                domain.getTags().stream()
                        .map(Tag::value)
                        .collect(Collectors.toList()),
                domain.getDocuments().stream()
                        .map(Document::value)
                        .collect(Collectors.toList()),
                domain.numberOfContributions()
        );
    }

    public Status getStatus(int status) {
        return switch (status) {
            case CaseEntity.STATUS_DRAFT -> Status.DRAFT;
            case CaseEntity.STATUS_OPENED -> Status.OPENED;
            default -> Status.CLOSED;
        };
    }

    private int getStatusCode(Status status) {
        return switch (status) {
            case DRAFT -> CaseEntity.STATUS_DRAFT;
            case OPENED -> CaseEntity.STATUS_OPENED;
            case CLOSED -> CaseEntity.STATUS_CLOSED;
        };
    }
}