package com.pt.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackerService {

    @Autowired
    private TorrentRepository torrentRepository;

    @Autowired
    private PeerRepository peerRepository;

    public Torrent addTorrent(String infoHash, String name) {
        Torrent torrent = new Torrent();
        torrent.setInfoHash(infoHash);
        torrent.setName(name);
        torrent.setAdded(new java.util.Date());
        return torrentRepository.save(torrent);
    }

    public Peer addPeer(String infoHash, String peerId, String ip, int port) {
        Peer peer = new Peer();
        peer.setInfoHash(infoHash);
        peer.setPeerId(peerId);
        peer.setIp(ip);
        peer.setPort(port);
        return peerRepository.save(peer);
    }

    public List<Peer> getPeers(String infoHash) {
        return peerRepository.findByInfoHash(infoHash);
    }
}
