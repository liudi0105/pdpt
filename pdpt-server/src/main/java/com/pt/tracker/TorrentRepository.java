package com.pt.tracker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TorrentRepository extends JpaRepository<Torrent, Long> {

    // 根据infoHash查询Torrent
    Optional<Torrent> findByInfoHash(String infoHash);

    // 根据name查询Torrent（可以用于模糊查询等）
    Optional<Torrent> findByName(String name);

    // 其他自定义查询方法可以根据需求添加
}
