package com.pd.server.tag;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TorrentTagsDTO {
    private Long id;
    private Integer torrentId;
    private Integer tagId;
}
