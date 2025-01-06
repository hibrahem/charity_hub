package com.charity_hub.cases.internal.application.commands.Contribute;

import com.charity_hub.cases.internal.domain.contracts.ICaseRepo;
import com.charity_hub.cases.internal.domain.model.Case.CaseCode;
import com.charity_hub.shared.abstractions.CommandHandler;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import com.charity_hub.shared.exceptions.NotFoundException;

@Service
public class ContributeHandler extends CommandHandler<Contribute, ContributeDefaultResponse> {
    private final ICaseRepo caseRepo;

    public ContributeHandler(ICaseRepo caseRepo) {
        this.caseRepo = caseRepo;
    }

    @Override
    public CompletableFuture<ContributeDefaultResponse> handle(Contribute command) {
        return CompletableFuture.supplyAsync(() -> {
            var case_ = caseRepo.getByCode(new CaseCode(command.caseCode())).join();
            if (case_ == null) {
                throw new NotFoundException("This case is not found");
            }

            var contribution = case_.contribute(command.userId(), command.amount());
            
            caseRepo.save(case_);
            return new ContributeDefaultResponse(contribution.contributionId());
        });
    }
}