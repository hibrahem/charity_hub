package com.charity_hub.ledger.internal.infrastructure.gateways;

import com.charity_hub.accounts.shared.AccountDTO;
import com.charity_hub.accounts.shared.IAccountsAPI;
import com.charity_hub.ledger.internal.application.contracts.IAccountGateway;
import com.charity_hub.ledger.internal.application.models.InvitationResponse;
import com.charity_hub.ledger.internal.domain.model.MemberId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component("ledgerAccountsGateway")
public class AccountsGateway implements IAccountGateway {
    private final IAccountsAPI accountsAPI;

    public AccountsGateway(IAccountsAPI accountsAPI) {
        this.accountsAPI = accountsAPI;
    }

    @Override
    public CompletableFuture<InvitationResponse> getInvitationByMobileNumber(String mobileNumber) {
        return accountsAPI.getInvitationByMobileNumber(mobileNumber)
                .thenApply(account -> {
                    if (account == null) {
                        return null;
                    }
                    return new InvitationResponse(
                            account.invitedMobileNumber(),
                            account.inviterId()
                    );
                });
    }

    @Override
    public CompletableFuture<List<AccountDTO>> getAccounts(List<MemberId> ids) {
        return accountsAPI.getAccountsByIds(ids.stream().map(MemberId::value).toList());

    }
}