package com.pt.server.torrents.torrent_secrets;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 实体类，映射表 torrent_secrets，记录种子的密钥信息。
 */
@Getter
@Setter
@Entity
@Table(name = "torrent_secrets")
public class TorrentSecretsPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false)
    private Integer uid; // 用户ID

    @Column(nullable = false)
    private Integer torrentId; // 种子ID

    @Column(nullable = false, length = 255)
    private String secret; // 种子密钥

    @Column(nullable = false)
    private LocalDateTime createdAt; // 创建时间

    @Column(nullable = false)
    private LocalDateTime updatedAt; // 更新时间
}