package com.pd.server.torrent;

import com.pd.server.auth.user_info.UsersDTO;
import com.pd.server.auth.user_info.UsersPO;
import com.pd.server.auth.user_info.UsersRepo;
import com.pd.server.category.CategoryDTO;
import com.pd.server.category.CategoryRepo;
import com.pd.server.torrent.tag.TagDTO;
import com.pd.server.torrent.tag.TagEntity;
import com.pd.server.torrent.tag.TagRepo;
import com.pd.server.torrent.torrent.TorrentsDTO;
import com.pd.server.torrent.torrent.TorrentsPO;
import com.pd.server.torrent.torrent.TorrentsRepo;
import com.pd.server.torrent.torrent_tag.TorrentTagsDTO;
import com.pd.server.torrent.torrent_tag.TorrentTagsEntity;
import com.pd.server.torrent.torrent_tag.TorrentTagsRepo;
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
