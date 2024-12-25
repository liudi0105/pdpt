package com.pt.server.torrents.torrent_deny_reasons;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据传输对象，传输种子拒绝理由信息。
 */
@Getter
@Setter
public class TorrentDenyReasonsDTO {

    private Long id; // 主键
    private String name; // 拒绝理由名称
    private Integer hits; // 被使用次数
    private Integer priority; // 优先级
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}