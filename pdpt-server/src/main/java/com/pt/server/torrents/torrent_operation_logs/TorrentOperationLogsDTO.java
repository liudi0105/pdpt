package com.pt.server.torrents.torrent_operation_logs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据传输对象，传输种子操作日志信息。
 */
@Getter
@Setter
public class TorrentOperationLogsDTO {

    private Long id; // 主键
    private Integer torrentId; // 种子ID
    private Integer uid; // 用户ID
    private String actionType; // 操作类型
    private String comment; // 备注信息
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}