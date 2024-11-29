package com.pd.server.torrent;

import com.mysql.cj.log.Log;
import com.pd.server.category.CategoryDTO;
import com.pd.server.category.CategoryRepo;
import com.pd.server.tag.*;
import com.pd.server.user_info.UserDTO;
import com.pd.server.user_info.UserPO;
import com.pd.server.user_info.UserRepo;
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
    private UserRepo userRepo;

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

        Map<Long, String> collect = userRepo.listIn(UserPO::getId, userId).stream().collect(Collectors.toMap(UserDTO::getId, UserDTO::getUsername));

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
