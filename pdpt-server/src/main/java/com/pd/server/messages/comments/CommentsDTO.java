package com.pd.server.messages.comments;

import com.pd.server.utils.BooleanEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentsDTO {
    private Integer id;
    private Integer user;
    private Integer torrent;
    private LocalDateTime added;
    private String text;
    private String oriText;
    private Integer editedby;
    private LocalDateTime editdate;
    private Integer offer;
    private Integer request;
    private BooleanEnum anonymous;
}
