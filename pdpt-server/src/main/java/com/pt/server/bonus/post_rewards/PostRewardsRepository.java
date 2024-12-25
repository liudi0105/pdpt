package com.pt.server.bonus.post_rewards;

import common.module.jpa.GeneralJpaRepo;

/**
 * 帖子奖励表的数据库接口
 * 提供对 `post_rewards` 表的数据库操作方法
 */
public interface PostRewardsRepository extends GeneralJpaRepo<PostRewardsPO, PostRewardsDTO, Long> {
}