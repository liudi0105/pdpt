package com.pt.server.torrents.torrent_tag;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "torrent_tags")
public class TorrentTagsEntity {
    @Id
    private Long id;
    private Integer torrentId;
    private Integer tagId;
}
