package com.pd.server.forum.post;

import com.pd.server.utils.BooleanEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "posts")
public class PostsEntity {
    @Id
    private Integer id;
    private Integer topicid;
    private Integer userid;
    private LocalDateTime added;
    private String body;
    private String oriBody;
    private Integer editedby;
    private LocalDateTime editdate;
}