package com.pt.server.invites.invites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "invites")
public class InvitesPO {
    @Id
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
