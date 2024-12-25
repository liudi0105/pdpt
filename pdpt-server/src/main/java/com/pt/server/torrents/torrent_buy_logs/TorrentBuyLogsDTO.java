package com.pt.server.torrents.torrent_buy_logs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据传输对象，传输种子购买日志信息。
 */
@Getter
@Setter
public class TorrentBuyLogsDTO {

    private Long id; // 主键
    private Integer uid; // 用户ID
    private Integer torrentId; // 种子ID
    private Integer price; // 价格（单位：积分）
    private String channel; // 购买渠道
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}