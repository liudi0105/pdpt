package com.pt.tracker;

import com.pt.tracker.Peer;
import com.pt.tracker.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tracker")
public class TrackerController {

    @Autowired
    private TrackerService trackerService;

    @GetMapping("/announce")
    public Object announce(@RequestParam String info_hash,
                           @RequestParam String peer_id,
                           @RequestParam String ip,
                           @RequestParam int port) {

        // 检查并添加种子（若不存在）
        trackerService.addTorrent(info_hash, "Unnamed");

        // 添加Peer信息
        Peer peer = trackerService.addPeer(info_hash, peer_id, ip, port);

        // 获取Peer列表
        List<Peer> peers = trackerService.getPeers(info_hash);

        return Map.of(
                "interval", 1800,  // 30分钟
                "peers", peers
        );
    }

    @GetMapping("/scrape")
    public Object scrape(@RequestParam String info_hash) {
        List<Peer> peers = trackerService.getPeers(info_hash);
        return Map.of(
                "files", Map.of(info_hash, Map.of(
                        "complete", 0,
                        "incomplete", peers.size(),
                        "downloaded", peers.size()
                ))
        );
    }
}
