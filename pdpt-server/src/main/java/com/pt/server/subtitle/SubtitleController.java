package com.pt.server.subtitle;

import com.pt.server.auth.user_info.UsersDTO;
import com.pt.server.auth.user_info.UsersPO;
import com.pt.server.auth.user_info.UsersRepo;
import com.pt.server.language.LanguageDTO;
import com.pt.server.language.LanguageEntity;
import com.pt.server.language.LanguageRepo;
import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApiGroup("subtitle")
public class SubtitleController {

    @Autowired
    private SubTitleRepo subTitleRepo;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private LanguageRepo languageRepo;

    @Api("list-paged")
    public AppPageResult<SubtitleDTO> listPaged(@RequestBody AppPageParam pageParam) {
        return subTitleRepo.pageQuery(pageParam, v -> v.orderBy(SubtitleEntity::getAdded))
                .handle(this::setUser).handle(this::setLang);
    }

    private void setLang(List<SubtitleDTO> postsDTOS) {
        Set<Short> list = postsDTOS.stream().map(SubtitleDTO::getLangId).collect(Collectors.toSet());
        Map<Short, LanguageDTO> collect = languageRepo.listIn(LanguageEntity::getId, list).stream().collect(Collectors.toMap(LanguageDTO::getId, Function.identity()));
        postsDTOS.stream().filter(v -> collect.containsKey(v.getLangId()))
                .forEach(v -> v.setLanguage(collect.get(v.getLangId()).getLangName()));
    }

    private void setUser(List<SubtitleDTO> postsDTOS) {
        Set<Long> list = postsDTOS.stream().map(SubtitleDTO::getUppedby).map(Long::valueOf).collect(Collectors.toSet());
        Map<Long, UsersDTO> collect = usersRepo.listIn(UsersPO::getId, list).stream().collect(Collectors.toMap(UsersDTO::getId, Function.identity()));
        postsDTOS.stream().filter(v -> collect.containsKey(v.getUppedby().longValue()))
                .forEach(v -> v.setUploadUsername(collect.get(v.getUppedby().longValue()).getUsername()));
    }
}
