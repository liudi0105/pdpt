package com.pd.server.torrent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TorrentTagsDTO {
    private Long id;
    private Integer torrentId;
    private Integer tagId;
}
