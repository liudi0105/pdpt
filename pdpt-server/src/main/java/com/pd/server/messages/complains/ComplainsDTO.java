package com.pd.server.messages.complains;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ComplainsDTO {
    private Long id;
    private Character uuid;
    private String email;
    private String body;
    private LocalDateTime added;
    private Short answered;
    private String ip;
}
