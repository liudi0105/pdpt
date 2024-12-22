package com.pd.server.bonus.log;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class BonusLogDTO {
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
