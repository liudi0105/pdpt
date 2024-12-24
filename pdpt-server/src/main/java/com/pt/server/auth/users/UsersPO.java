package com.pt.server.auth.users;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class UsersPO {
    @Id
    private Long id; // 用户ID

    @Column(nullable = false, length = 40)
    private String username; // 用户名

    @Column(nullable = false, length = 32)
    private String passhash; // 密码哈希

    @Column(nullable = false)
    private byte[] secret; // 密码盐（加密用）

    @Column(nullable = false, length = 80)
    private String email; // 用户邮箱

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status; // 用户状态（例如：pending, confirmed）

    @Column(nullable = false)
    private String ip; // 用户IP地址

    @Column(nullable = false)
    private Long uploaded; // 上传量

    @Column(nullable = false)
    private Long downloaded; // 下载量

    @Column(nullable = false)
    private Long seedtime; // 上传时间（做种时间）

    @Column(nullable = false)
    private Long leechtime; // 下载时间（做种时间）

    @Column(nullable = false, length = 255)
    private String title; // 用户头衔

    @Column(nullable = false)
    private Short country; // 国家ID

    // Enum for user status
    public enum UserStatus {
        pending, // 用户处于待确认状态
        confirmed // 用户已确认
    }
}
