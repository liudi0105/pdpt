package com.pt.server.torrents.tag;

import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.function.UnaryOperator;

@ApiGroup("tags")
public class TagsController {

    @Autowired
    private TagRepo tagRepo;

    @Api("list-paged")
    public AppPageResult<TagDTO> listPaged(@RequestBody AppPageParam pageParam) {
        return tagRepo.pageQuery(pageParam, UnaryOperator.identity());
    }

}
