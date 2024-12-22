package com.pd.server.medals.medals;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
public class MedalsDTO {
    private Long id;
    private String name;
    private Integer getType;
    private String description;
    private String imageLarge;
    private String imageSmall;
    private Integer price;
    private Integer displayOnMedalPage;
    private Double bonusAdditionFactor;
    private Double giftFeeFactor;
    private Integer duration;
    private Instant createdAt;
    private Instant updatedAt;
    private LocalDateTime saleBeginTime;
    private LocalDateTime saleEndTime;
}
