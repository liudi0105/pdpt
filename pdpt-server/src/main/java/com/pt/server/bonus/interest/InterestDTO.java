package com.pt.server.bonus.interest;

import lombok.Getter;
import lombok.Setter;

/**
 * 利息记录数据传输对象
 * 用于在系统中传递用户银行账户利息数据
 */
@Getter
@Setter
public class InterestDTO {
    private Long id; // 主键
    private Long uid; // 用户ID
    private Double interest; // 已结利息
    private Double uninterest; // 未结利息
    private String createdAt; // 创建时间
    private String updatedAt; // 更新时间
}