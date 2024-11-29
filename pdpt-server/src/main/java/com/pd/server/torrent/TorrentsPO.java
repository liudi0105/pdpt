package com.pd.server.torrent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "torrents")
public class TorrentsPO {
    @Id
    private Integer id;
    private String name;
    private String filename;
    private String saveAs;
    private String cover;
    private String descr;
    private String smallDescr;
    private String oriDescr;
    private Long size;
    private Short category;
    private Byte source;
    private LocalDateTime added;
    private Byte medium;
    private Short numfiles;
    private Integer comments;
    private Integer views;
    private Integer hits;
    private Integer leechers;
    private Integer seeders;
    private String ptGen;
    private Integer owner;
    private Byte hr;
}
