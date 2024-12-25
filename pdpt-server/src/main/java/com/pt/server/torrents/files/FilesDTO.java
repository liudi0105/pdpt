package com.pt.server.torrents.files;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据传输对象，传输种子文件信息。
 */
@Getter
@Setter
public class FilesDTO {

    private Long id; // 主键
    private Long torrent; // 种子ID
    private String filename; // 文件名
    private Long size; // 文件大小，单位：字节
}