package com.pt.server.bonus.torrent_buy_logs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 种子购买记录表
 * 用于记录用户购买种子的详细信息
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
    private Integer price; // 种子价格

    @Column(nullable = false, length = 255)
    private String channel; // 支付渠道

    @Column(nullable = false)
    private String createdAt; // 创建时间

    @Column(nullable = false)
    private String updatedAt; // 更新时间
}