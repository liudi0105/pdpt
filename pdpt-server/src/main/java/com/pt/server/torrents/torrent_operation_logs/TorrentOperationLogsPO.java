package com.pt.server.torrents.torrent_operation_logs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 实体类，映射表 torrent_operation_logs，记录种子操作日志。
 */
@Getter
@Setter
@Entity
@Table(name = "torrent_operation_logs")
public class TorrentOperationLogsPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false)
    private Integer torrentId; // 种子ID

    @Column(nullable = false)
    private Integer uid; // 用户ID

    @Column(nullable = false, length = 255)
    private String actionType; // 操作类型

    @Column(nullable = false, length = 255)
    private String comment; // 备注信息

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}