package com.pt.server.bonus.free_pool_feed_record;

import common.module.jpa.GeneralJpaRepo;

/**
 * 魔力池投喂记录表的数据库接口
 * 提供对 `free_pool_feed_record` 表的数据库操作
 */
public interface FreePoolFeedRecordRepository extends GeneralJpaRepo<FreePoolFeedRecordPO, FreePoolFeedRecordDTO, Long> {
}