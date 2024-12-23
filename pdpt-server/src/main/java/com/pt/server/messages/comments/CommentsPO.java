package com.pt.server.messages.comments;

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
@Table(name = "comments")
public class CommentsPO {
    @Id
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
    @Enumerated(EnumType.STRING)
    private BooleanEnum anonymous;
}
