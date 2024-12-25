package com.pt.server.bonus.torrent_buy_logs;

import lombok.Getter;
import lombok.Setter;

/**
 * 种子购买记录数据传输对象
 * 用于在系统内传递种子购买记录的相关数据
 */
@Getter
@Setter
public class TorrentBuyLogsDTO {
    private Long id; // 主键
    private Integer uid; // 用户ID
    private Integer torrentId; // 种子ID
    private Integer price; // 种子价格
    private String channel; // 支付渠道
    private String createdAt; // 创建时间
    private String updatedAt; // 更新时间
}