package com.pt.server.bonus.free_pool_feed_record;

import lombok.Getter;
import lombok.Setter;

/**
 * 魔力池投喂记录数据传输对象
 * 包含用户投喂的魔力值及相关信息
 */
@Getter
@Setter
public class FreePoolFeedRecordDTO {
    private Long id; // 主键
    private Long uid; // 用户ID
    private Double bonus; // 投喂魔力值
    private Integer periods; // 期数
    private String createdAt; // 创建时间
    private String updatedAt; // 更新时间
}