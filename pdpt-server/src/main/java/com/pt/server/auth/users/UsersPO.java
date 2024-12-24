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
    private Long id;

    @Column(nullable = false, length = 40)
    private String username;

    @Column(nullable = false, length = 32)
    private String passhash;

    @Column(nullable = false)
    private byte[] secret;

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
    private Short country;

    // Enum for user status
    public enum UserStatus {
        pending,
        confirmed
    }}
