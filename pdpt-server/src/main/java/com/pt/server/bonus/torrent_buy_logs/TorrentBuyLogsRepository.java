package com.pt.server.bonus.torrent_buy_logs;

import common.module.jpa.GeneralJpaRepo;

/**
 * 种子购买记录表的数据库接口
 * 提供对 `torrent_buy_logs` 表的数据库操作方法
 */
public interface TorrentBuyLogsRepository extends GeneralJpaRepo<TorrentBuyLogsPO, TorrentBuyLogsDTO, Long> {
}