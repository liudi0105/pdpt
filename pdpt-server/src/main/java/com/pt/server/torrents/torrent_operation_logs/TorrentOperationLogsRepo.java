package com.pt.server.torrents.torrent_operation_logs;

import common.module.jpa.GeneralJpaRepo;

/**
 * 存储库接口，提供访问 torrent_operation_logs 数据表的方法。
 */
public interface TorrentOperationLogsRepo extends GeneralJpaRepo<TorrentOperationLogsPO, TorrentOperationLogsDTO, Long> {
    // 自定义查询方法可在此定义
}