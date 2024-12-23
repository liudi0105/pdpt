package com.pt.tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "peers")
@Getter  // 自动生成getter方法
@Setter  // 自动生成setter方法
public class Peer {
    @Id
    private String peerId;
    private String infoHash;
    private String ip;
    private int port;
}
