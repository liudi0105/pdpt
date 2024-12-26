package com.pt.server.torrents.thanks;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 实体类，映射表 thanks，用于存储用户感谢信息。
 */
@Getter
@Setter
@Entity
@Table(name = "thanks")
public class ThanksPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 主键

    @Column(nullable = false)
    private Integer torrentid; // 种子ID

    @Column(nullable = false)
    private Integer userid; // 用户ID
}