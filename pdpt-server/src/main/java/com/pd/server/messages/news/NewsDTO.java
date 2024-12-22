package com.pd.server.messages.news;

import com.pd.server.utils.BooleanEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NewsDTO {
    private Integer id;
    private Integer userid;
    private LocalDateTime added;
    private String body;
    private String title;
    private BooleanEnum notify;
}
