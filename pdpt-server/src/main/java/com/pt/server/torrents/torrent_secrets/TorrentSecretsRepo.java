package com.pt.server.torrents.torrent_secrets;

import common.module.jpa.GeneralJpaRepo;

/**
 * 存储库接口，提供访问 torrent_secrets 数据表的方法。
 */
public interface TorrentSecretsRepo extends GeneralJpaRepo<TorrentSecretsPO, TorrentSecretsDTO, Long> {
    // 自定义查询方法可在此定义
}