package com.pt.tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "torrents")
@Getter  // 自动生成getter方法
@Setter  // 自动生成setter方法
public class Torrent {
    @Id
    private String infoHash;
    private String name;
    private Date added;
}
