package com.pt.server.torrents.torrents_custom_fields;

import common.module.jpa.GeneralJpaRepo;

/**
 * 存储库接口，提供访问 torrent_custom_fields 数据表的方法。
 */
public interface TorrentsCustomFieldsRepo extends GeneralJpaRepo<TorrentsCustomFieldsPO, TorrentsCustomFieldsDTO, Long> {
    // 自定义查询方法可在此定义
}