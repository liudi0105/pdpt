package com.pt.server.torrents.torrent_secrets;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据传输对象，传输种子密钥信息。
 */
@Getter
@Setter
public class TorrentSecretsDTO {

    private Long id; // 主键
    private Integer uid; // 用户ID
    private Integer torrentId; // 种子ID
    private String secret; // 种子密钥
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}