package com.pt.server.messages.complain_reply;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "complain_replies")
public class ComplainRepliesPO {
    @Id
    private Long id;
    private Integer complain;
    private Integer userid;
    private LocalDateTime added;
    private String body;
    private String ip;
}
