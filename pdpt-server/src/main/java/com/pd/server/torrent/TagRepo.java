package com.pd.server.torrent;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends GeneralJpaRepo<TagEntity, TagDTO, Short> {
}
