package com.pt.server.torrents.torrent_deny_reasons;

import common.module.jpa.GeneralJpaRepo;

/**
 * 存储库接口，提供访问 torrent_deny_reasons 数据表的方法。
 */
public interface TorrentDenyReasonsRepo extends GeneralJpaRepo<TorrentDenyReasonsPO, TorrentDenyReasonsDTO, Long> {
    // 自定义查询方法可在此定义
}