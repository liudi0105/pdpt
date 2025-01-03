package com.pt.server.forum.overforums;

import com.pt.server.forum.forums.ForumsDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OverForumsDTO {
    private Short id;
    private String name;
    private String description;
    private Byte minclassview;
    private Byte sort;

    private List<ForumsDTO> forums;
}