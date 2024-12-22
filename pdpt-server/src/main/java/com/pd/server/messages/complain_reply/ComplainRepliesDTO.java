package com.pd.server.messages.complain_reply;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ComplainRepliesDTO {
    private Long id;
    private Integer complain;
    private Integer userid;
    private LocalDateTime added;
    private String body;
    private String ip;
}
