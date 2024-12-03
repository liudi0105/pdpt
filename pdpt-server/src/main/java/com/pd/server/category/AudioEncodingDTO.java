package com.pd.server.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AudioEncodingDTO {
    private Byte id;
    private String name;
    private Byte sortIndex;
    private Integer mode;
}
