package com.pt.server.torrents.torrent_deny_reasons;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 实体类，映射表 torrent_deny_reasons，记录种子拒绝理由。
 */
@Getter
@Setter
@Entity
@Table(name = "torrent_deny_reasons")
public class TorrentDenyReasonsPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false, length = 255)
    private String name; // 拒绝理由名称

    @Column(nullable = false)
    private Integer hits; // 被使用次数

    @Column(nullable = false)
    private Integer priority; // 优先级

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}