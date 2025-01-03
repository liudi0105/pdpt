package com.pt.server.torrents.requests;

import com.pt.server.utils.BooleanEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RequestsDTO {
    private Integer id;
    private Integer userid;
    private String request;
    private String descr;
    private Integer comments;
    private Integer hits;
    private Integer cat;
    private Integer filledby;
    private Integer torrentid;
    private BooleanEnum finish;
    private Integer amount;
    private String oriDescr;
    private Integer oriAmount;
    private LocalDateTime added;
    private String username;
}
