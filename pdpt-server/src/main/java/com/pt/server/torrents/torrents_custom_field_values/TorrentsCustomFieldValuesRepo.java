package com.pt.server.torrents.torrents_custom_field_values;

import common.module.jpa.GeneralJpaRepo;

/**
 * 存储库接口，提供访问 torrents_custom_fields_values 数据表的方法。
 */
public interface TorrentsCustomFieldValuesRepo extends GeneralJpaRepo<TorrentsCustomFieldValuesPO, TorrentsCustomFieldValuesDTO, Long> {
    // 自定义查询方法可在此定义
}