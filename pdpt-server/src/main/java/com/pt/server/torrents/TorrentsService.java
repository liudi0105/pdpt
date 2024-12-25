package com.pt.server.torrents;

import com.pt.server.auth.users.UsersDTO;
import com.pt.server.auth.users.UsersPO;
import com.pt.server.auth.users.UsersRepo;
import com.pt.server.category.CategoryDTO;
import com.pt.server.category.CategoryRepo;
import com.pt.server.torrents.tag.TagDTO;
import com.pt.server.torrents.tag.TagEntity;
import com.pt.server.torrents.tag.TagRepo;
import com.pt.server.torrents.torrents.TorrentsDTO;
import com.pt.server.torrents.torrents.TorrentsPO;
import com.pt.server.torrents.torrents.TorrentsRepo;
import com.pt.server.torrents.torrent_tag.TorrentTagsDTO;
import com.pt.server.torrents.torrent_tag.TorrentTagsEntity;
import com.pt.server.torrents.torrent_tag.TorrentTagsRepo;
import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TorrentsService {

    @Autowired
    private TorrentsRepo torrentsRepo;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private TagRepo tagRepo;

    @Autowired
    private TorrentTagsRepo torrentTagsRepo;

    public List<TagDTO> listTagsByTorrentId(Integer id) {
        List<TorrentTagsDTO> torrentTagsDTOS = torrentTagsRepo.listEq(TorrentTagsEntity::getTorrentId, id);
        Set<Long> collect = torrentTagsDTOS.stream().map(v -> (long) v.getTagId()).collect(Collectors.toSet());
        return tagRepo.listIn(TagEntity::getId, collect);
    }

    public TorrentsDTO getOneById(Integer id) {
        TorrentsDTO torrentsDTO = torrentsRepo.getOneById(id);
        List<String> list = listTagsByTorrentId(torrentsDTO.getId()).stream().map(TagDTO::getName).toList();
        torrentsDTO.setTags(list);
        return torrentsDTO;
    }

    public AppPageResult<TorrentsDTO> listPaged(@RequestBody AppPageParam appPageParam) {
        AppPageResult<TorrentsDTO> torrentsDTOAppPageResult = torrentsRepo.pageQuery(appPageParam, v -> v.orderBy(TorrentsPO::getAdded).desc());

        Set<Long> userId = torrentsDTOAppPageResult.getContent().stream().map(TorrentsDTO::getOwner).collect(Collectors.toSet());

        Map<Long, String> collect = usersRepo.listIn(UsersPO::getId, userId).stream().collect(Collectors.toMap(UsersDTO::getId, UsersDTO::getUsername));

        torrentsDTOAppPageResult.getContent().forEach(v -> v.setOwnerName(collect.get(v.getOwner())));
        setCategoryCode(torrentsDTOAppPageResult.getContent());

        return torrentsDTOAppPageResult;
    }

    public void setCategoryCode(List<TorrentsDTO> torrentsDTOS) {
        Set<Short> collect = torrentsDTOS.stream().map(TorrentsDTO::getCategory).collect(Collectors.toSet());
        Map<Short, CategoryDTO> collect1 = categoryRepo.listByIds(collect).stream().collect(Collectors.toMap(CategoryDTO::getId, Function.identity()));
        torrentsDTOS.forEach(v -> v.setCategoryCode(collect1.get(v.getCategory()).getClassName()));
    }
}
