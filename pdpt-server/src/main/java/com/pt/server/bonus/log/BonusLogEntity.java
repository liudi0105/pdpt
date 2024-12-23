package com.pt.server.bonus.log;

import common.module.util.JsonSerializers;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "bonus_logs")
public class BonusLogEntity {
    @Id
    private Long id;
    private Integer businessType;
    private Integer uid;
    private BigDecimal oldTotalValue;
    private BigDecimal newTotalValue;
    private BigDecimal value;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
