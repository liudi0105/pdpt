package com.pt.server.torrents.thanks;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据传输对象，用于传递感谢信息。
 */
@Getter
@Setter
public class ThanksDTO {

    private Long id; // 主键
    private Long torrentid; // 种子ID
    private Long userid; // 用户ID
}