package com.pt.server.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResolutionDTO {
    private Integer id;
    private String name;
    private Byte sortIndex;
    private Integer mode;
}
