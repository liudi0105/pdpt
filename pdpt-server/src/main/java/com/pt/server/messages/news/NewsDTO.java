package com.pt.server.messages.news;

import com.pt.server.utils.BooleanEnum;
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
