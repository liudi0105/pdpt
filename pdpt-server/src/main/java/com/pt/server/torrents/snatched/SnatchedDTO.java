package com.pt.server.torrents.snatched;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据传输对象，传输种子下载、做种信息。
 */
@Getter
@Setter
public class SnatchedDTO {

    private Integer id; // 主键
    private Integer torrentId; // 种子ID
    private Integer userId; // 用户ID
    private String ip; // 用户IP地址
    private Integer port; // 用户端口
    private Long uploaded; // 上传的字节数
    private Long downloaded; // 下载的字节数
    private Long toGo; // 剩余未下载的字节数
    private Integer seedTime; // 做种时长（秒）
    private Integer leechTime; // 下载时长（秒）
    private LocalDateTime lastAction; // 最后交互时间
    private LocalDateTime startDate; // 开始下载时间
    private LocalDateTime completeDate; // 下载完成时间
    private String finished; // 是否完成 ("yes" or "no")
}