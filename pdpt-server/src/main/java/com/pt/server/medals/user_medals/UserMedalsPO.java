package com.pt.server.medals.user_medals;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "user_medals")
public class UserMedalsPO {
    @Id
    private Long id;
    private Integer uid;
    private Integer medalId;
    private LocalDateTime expireAt;
    private Instant createdAt;
    private Instant updatedAt;
    private Integer status;
    private Integer priority;
}
