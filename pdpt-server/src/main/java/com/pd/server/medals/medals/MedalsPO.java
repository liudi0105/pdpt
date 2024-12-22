package com.pd.server.medals.medals;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "medals")
public class MedalsPO {
    @Id
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
