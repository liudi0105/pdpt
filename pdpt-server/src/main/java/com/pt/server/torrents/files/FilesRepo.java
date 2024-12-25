package com.pt.server.torrents.files;

import common.module.jpa.GeneralJpaRepo;

/**
 * 存储库接口，提供访问 files 数据表的方法。
 */
public interface FilesRepo extends GeneralJpaRepo<FilesPO, FilesDTO, Long> {
    // 自定义查询方法可在此定义
}