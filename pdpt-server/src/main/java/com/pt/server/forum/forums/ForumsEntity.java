package com.pt.server.forum.forums;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.hc.core5.http.nio.support.classic.SharedOutputBuffer;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "forums")
public class ForumsEntity {
    @Id
    private Short id;
    private String name;
    private String description;
    private Byte minclassread;
    private Byte minclasswrite;
    private Integer postcount;
    private Integer topiccount;
    private Byte minclasscreate;
    private Short forid;
    private Short sort;
}
