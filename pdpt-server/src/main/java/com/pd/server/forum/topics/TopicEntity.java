package com.pd.server.forum.topics;

import com.pd.server.utils.BooleanEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "topics")
public class TopicEntity {
    @Id
    private Integer id;
    private Integer userid;
    private String subject;
    @Enumerated(EnumType.STRING)
    private BooleanEnum locked;
    private Short forumid ;
    private Integer firstpost;
    private Integer lastpost;
    @Enumerated(EnumType.STRING)
    private BooleanEnum sticky;
    private Byte hlcolor;
    private Integer views;
}
