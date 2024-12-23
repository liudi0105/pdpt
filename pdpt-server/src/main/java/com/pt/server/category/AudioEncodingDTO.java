package com.pt.server.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AudioEncodingDTO {
    private Integer id;
    private String name;
    private Byte sortIndex;
    private Integer mode;
}
