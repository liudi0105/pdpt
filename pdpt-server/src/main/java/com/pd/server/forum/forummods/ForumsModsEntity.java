package com.pd.server.forum.forummods;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "forummods")
public class ForumsModsEntity {
    @Id
    private Short id;
    private Short forumid;
    private Integer userid;
}
