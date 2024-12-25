package com.pt.server.torrents.thanks;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据传输对象，用于传递感谢信息。
 */
@Getter
@Setter
public class ThanksDTO {
    private Integer id; // 主键
    private Integer torrentid; // 种子ID
    private Integer userid; // 用户ID
}