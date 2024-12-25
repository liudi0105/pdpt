package com.pt.server.torrents.files;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 实体类，映射表 files，定义种子文件信息。
 */
@Getter
@Setter
@Entity
@Table(name = "files")
public class FilesPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 主键

    @Column(nullable = false)
    private Integer torrent; // 种子ID

    @Column(nullable = false, length = 255)
    private String filename; // 文件名

    @Column(nullable = false)
    private Long size; // 文件大小，单位：字节
}