package com.pt.server.bonus.post_rewards;

import lombok.Getter;
import lombok.Setter;

/**
 * 帖子奖励数据传输对象
 * 用于在系统内传递帖子奖励的相关数据
 */
@Getter
@Setter
public class PostRewardsDTO {
    private Long id; // 主键
    private Integer postId; // 帖子ID
    private Integer uid; // 用户ID
    private Integer bonus; // 奖励积分
    private String comment; // 奖励备注
    private Integer position; // 帖子位置
    private String createdAt; // 创建时间
    private String updatedAt; // 更新时间
}