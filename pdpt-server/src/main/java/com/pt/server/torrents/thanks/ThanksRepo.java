package com.pt.server.torrents.thanks;

import common.module.jpa.GeneralJpaRepo;

/**
 * 存储库接口，用于访问 thanks 数据表。
 */
public interface ThanksRepo extends GeneralJpaRepo<ThanksPO, ThanksDTO, Long> {
    // 自定义查询方法可在此定义
}