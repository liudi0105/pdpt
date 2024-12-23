package com.pt.server.invites.invites;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDateTime;

@Getter
@Setter
public class InvitesDTO {
    private Integer id;
    private Integer inviter;
    private String invitee;
    private Character hash;
    private LocalDateTime timeInvited;
    private Byte valid;
    private Integer inviteeRegisterUid;
    private String inviteeRegisterEmail;
    private String inviteeRegisterUsername;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;
}
