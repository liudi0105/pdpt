package com.pt.server.torrents.snatched;

import common.module.jpa.GeneralJpaRepo;

/**
 * 存储库接口，提供访问 snatched 数据表的方法。
 */
public interface SnatchedRepo extends GeneralJpaRepo<SnatchedPO, SnatchedDTO, Integer> {
    // 自定义查询方法可在此定义
}