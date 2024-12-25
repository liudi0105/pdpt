package com.pt.server.bonus.post_rewards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 帖子奖励表
 * 用于存储用户在特定帖子中获得的奖励信息
 */
@Getter
@Setter
@Entity
@Table(name = "post_rewards")
public class PostRewardsPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false)
    private Integer postId; // 帖子ID

    @Column(nullable = false)
    private Integer uid; // 用户ID

    @Column(nullable = false)
    private Integer bonus; // 奖励积分

    @Column(nullable = false, length = 255)
    private String comment; // 奖励备注

    @Column(nullable = false)
    private Integer position; // 帖子位置

    @Column(nullable = false)
    private String createdAt; // 创建时间

    @Column(nullable = false)
    private String updatedAt; // 更新时间
}