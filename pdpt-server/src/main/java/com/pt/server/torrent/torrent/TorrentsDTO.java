package com.pt.server.torrent.torrent;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class TorrentsDTO {
    private Integer id;
    private String name;
    private String filename;
    private String saveAs;
    private String cover;
    private String descr;
    private String smallDescr;
    private String oriDescr;
    private Short category;
    private String categoryCode;
    private Long size;
    private LocalDateTime added;
    private Byte source;
    private Byte medium;
    private Short numfiles;
    private Integer comments;
    private Integer views;
    private Integer hits;
    private Integer leechers;
    private Integer seeders;
    private String ptGen;
    private Byte hr;
    private String ownerName;
    private Long owner;
    private List<String> tags;
}
