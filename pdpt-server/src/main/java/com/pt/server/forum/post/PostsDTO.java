package com.pt.server.forum.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostsDTO {
    private Integer id;
    private Integer topicid;
    private Integer userid;
    private String username;
    private LocalDateTime added;
    private String body;
    private String oriBody;
    private Integer editedby;
    private LocalDateTime editdate;
}
