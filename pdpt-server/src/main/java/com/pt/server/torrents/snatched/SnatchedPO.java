package com.pt.server.torrents.snatched;

import com.pt.server.utils.BooleanEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 实体类，映射表 snatched，记录种子下载、做种信息。
 */
@Getter
@Setter
@Entity
@Table(name = "snatched")
public class SnatchedPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false)
    private Integer torrentid; // 种子ID

    @Column(nullable = false)
    private Integer userid; // 用户ID

    @Column(nullable = false, length = 64)
    private String ip; // 用户IP地址

    @Column(nullable = false)
    private Short port; // 用户端口

    @Column(nullable = false)
    private Long uploaded; // 上传的字节数

    @Column(nullable = false)
    private Long downloaded; // 下载的字节数

    @Column(nullable = false)
    private Long toGo; // 剩余未下载的字节数

    @Column(nullable = false)
    private Integer seedtime; // 做种时长（秒）

    @Column(nullable = false)
    private Integer leechtime; // 下载时长（秒）

    private LocalDateTime lastAction; // 最后交互时间

    private LocalDateTime startdat; // 开始下载时间

    private LocalDateTime completedat; // 下载完成时间

    @Column(nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private BooleanEnum finished; // 是否完成 ("yes" or "no")
}