package com.pt.server.forum.forums;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForumsDTO {
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
    private String blockName;
}
