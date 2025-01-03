package com.pt.server.messages.news;

import com.pt.server.utils.BooleanEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "news")
public class NewsPO {
    @Id
    private Integer id;
    private Integer userid;
    private LocalDateTime added;
    private String body;
    private String title;
    @Enumerated(EnumType.STRING)
    private BooleanEnum notify;
}
