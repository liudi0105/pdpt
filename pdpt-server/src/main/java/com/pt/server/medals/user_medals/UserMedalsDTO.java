package com.pt.server.medals.user_medals;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserMedalsDTO {
    private Long id;
    private LocalDateTime added;
    private String txt;
    private  SecurityLevel securityLevel;

    public enum SecurityLevel {
        normal, mod,
        ;
    }
}
