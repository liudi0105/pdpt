package com.pt.server.auth.user_info;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class UsersPO {
    @Id
    private Long id;
    @Column(nullable = false, length = 40)
    private String username;

    @Column(nullable = false, length = 32)
    private String passhash;

    @Column(nullable = false)
    private String secret;

    @Column(nullable = false, length = 80)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;

    @Column(nullable = false)
    private String ip;

    @Column(nullable = false)
    private Long uploaded;

    @Column(nullable = false)
    private Long downloaded;

    @Column(nullable = false)
    private Long seedtime;

    @Column(nullable = false)
    private Long leechtime;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private int country;

    // Enum for user status
    public enum UserStatus {
        PENDING,
        CONFIRMED
    }}
