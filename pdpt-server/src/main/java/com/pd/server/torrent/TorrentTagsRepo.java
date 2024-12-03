package com.pd.server.torrent;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface TorrentTagsRepo extends GeneralJpaRepo<TorrentTagsEntity, TorrentTagsDTO, Long> {
}
