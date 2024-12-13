package com.pd.server.subtitle;

import com.pd.server.utils.BooleanEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SubtitleDTO {
    private Integer id;
    private Integer torrentId;
    private Short langId;
    private String title;
    private String filename;
    private LocalDateTime added;
    private Integer uppedby;
    private BooleanEnum anonymous;
    private Integer hits;
    private String ext;
    private String uploadUsername;
    private String language;
    private Long size;
}
