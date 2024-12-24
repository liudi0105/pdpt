package com.pt.server.auth.users;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UsersDTO {
    private Long id; // 用户ID
    private String username; // 用户名
    private String passhash; // 密码哈希
    private byte[] secret; // 密码盐
    private String email; // 用户邮箱
    private String status; // 用户状态（例如：pending, confirmed）
    private String ip; // 用户IP地址
    private Long uploaded; // 上传量
    private Long downloaded; // 下载量
    private Long seedtime; // 上传时间（种子时间）
    private Long leechtime; // 下载时间（做种时间）
    private String title; // 用户头衔
    private Short country; // 国家ID
    private String notifs; // 通知设置
    private String modcomment; // 管理员备注
    private String avatar; // 用户头像
    private String className; // 用户角色（权限级别）
    private String maxClassOnce; // 最大角色（权限）一次性
    private String privacy; // 隐私设置
    private String stylesheet; // 样式表
    private String caticon; // 图标
    private String fontsize; // 字体大小
    private String acceptpms; // 是否接受PM
    private String commentpm; // 是否允许评论PM
    private String lastLogin; // 最后登录时间
    private String lastAccess; // 最后访问时间
    private String forumAccess; // 最后论坛访问时间
    private String lastStaffmsg; // 最后管理信息
    private String lastPm; // 最后私信时间
    private String lastComment; // 最后评论时间
    private String lastPost; // 最后发帖时间
    private String lastBrowse; // 最后浏览时间
    private String lastMusic; // 最后听音乐时间
    private String lastCatchup; // 最后刷新时间
    private String editSecret; // 编辑密码盐
    private String ipAddress; // 当前用户的IP地址
    private String language; // 用户的语言设置
    private String modcommentText; // 管理员备注文本
}
