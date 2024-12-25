package com.pt.server.torrents.torrent_buy_logs;

import common.module.jpa.GeneralJpaRepo;

/**
 * 存储库接口，提供访问 torrent_buy_logs 数据表的方法。
 */
public interface TorrentBuyLogsRepo extends GeneralJpaRepo<TorrentBuyLogsPO, TorrentBuyLogsDTO, Long> {
    // 自定义查询方法可在此定义
}