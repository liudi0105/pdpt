package com.pt.tracker;

import com.pt.tracker.Peer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PeerRepository extends JpaRepository<Peer, Long> {
    List<Peer> findByInfoHash(String infoHash);
}
