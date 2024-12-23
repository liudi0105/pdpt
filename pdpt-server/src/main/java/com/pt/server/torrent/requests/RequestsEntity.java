package com.pt.server.torrent.requests;

import com.pt.server.utils.BooleanEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "requests")
public class RequestsEntity {
    @Id
    private Integer id;
    private Integer userid;
    private String request;
    private String descr;
    private Integer comments;
    private Integer hits;
    private Integer cat;
    private Integer filledby;
    private Integer torrentid;
    @Enumerated(EnumType.STRING)
    private BooleanEnum finish;
    private Integer amount;
    private String oriDescr;
    private Integer oriAmount;
    private LocalDateTime added;
}
