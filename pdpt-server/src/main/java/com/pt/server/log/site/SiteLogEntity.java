package com.pt.server.log.site;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "sitelog")
public class SiteLogEntity {
    @Id
    private Integer id;
    private LocalDateTime added;
    private String txt;
    @Enumerated(EnumType.STRING)
    private SiteLogDTO.SecurityLevel securityLevel;
}
