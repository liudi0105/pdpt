package com.pd.server.forum.topics;

import com.pd.server.utils.BooleanEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
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
    private String blockName;
    private String forumName;
}
