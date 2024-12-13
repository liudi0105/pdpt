package com.pd.server.subtitle;

import com.pd.server.utils.BooleanEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "subs")
public class SubtitleEntity {
    @Id
    private Integer id;
    private Integer torrentId;
    private Short langId;
    private String title;
    private String filename;
    private LocalDateTime added;
    private Integer uppedby;
    @Enumerated(EnumType.STRING)
    private BooleanEnum anonymous;
    private Integer hits;
    private String ext;
    private Long size;
}
