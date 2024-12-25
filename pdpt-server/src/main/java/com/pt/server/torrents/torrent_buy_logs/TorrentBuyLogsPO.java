package com.pt.server.torrents.torrent_buy_logs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 实体类，映射表 torrent_buy_logs，记录种子购买日志。
 */
@Getter
@Setter
@Entity
@Table(name = "torrent_buy_logs")
public class TorrentBuyLogsPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false)
    private Integer uid; // 用户ID

    @Column(nullable = false)
    private Integer torrentId; // 种子ID

    @Column(nullable = false)
    private Integer price; // 价格（单位：积分）

    @Column(nullable = false, length = 255)
    private String channel; // 购买渠道

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}