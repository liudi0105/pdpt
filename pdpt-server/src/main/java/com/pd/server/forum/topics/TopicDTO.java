package com.pd.server.forum.topics;

import com.pd.server.utils.BooleanEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDTO {
    private Integer id;
    private Integer userid;
    private String subject;
    private BooleanEnum locked;
    private Short forumid ;
    private Integer firstpost;
    private Integer lastpost;
    private BooleanEnum sticky;
    private Byte hlcolor;
    private Integer views;
    private String author;
}
