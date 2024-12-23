package com.pt.server.log.site;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SiteLogDTO {
    private Integer id;
    private LocalDateTime added;
    private String txt;
    private  SecurityLevel securityLevel;

    public enum SecurityLevel {
        normal, mod,
        ;
    }
}
