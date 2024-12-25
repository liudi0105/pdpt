package com.pt.server.bonus.free_pool_feed_record;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 魔力池投喂记录表
 * 用于记录用户在魔力池中的投喂操作
 */
@Getter
@Setter
@Entity
@Table(name = "free_pool_feed_record")
public class FreePoolFeedRecordPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false)
    private Long uid; // 用户ID

    @Column(nullable = false, precision = 20, scale = 1)
    private Double bonus; // 投喂魔力值

    @Column(nullable = false)
    private Integer periods; // 期数

    @Column(nullable = false)
    private String createdAt; // 创建时间

    @Column(nullable = false)
    private String updatedAt; // 更新时间
}