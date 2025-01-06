package com.charity_hub.accounts.internal.shell.repositories.mappers;

import com.charity_hub.accounts.internal.core.model.invitation.Invitation;
import com.charity_hub.accounts.internal.shell.db.InvitationEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InvitationMapper {

    public Invitation fromEntity(InvitationEntity entity) {
        return Invitation.of(
            entity.mobileNumber(),
            UUID.fromString(entity.inviterId())
        );
    }

    public InvitationEntity toEntity(Invitation invitation) {
        return new InvitationEntity(
            invitation.invitedMobileNumber().value(),
            invitation.inviterId().toString()
        );
    }
}