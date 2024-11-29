package com.pd.server.category;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CategoryDTO {
    private Short id;
    private Byte mode;
    private String className;
    private String name;
    private String image;
    private Short sortIndex;
    private Integer iconId;
}
