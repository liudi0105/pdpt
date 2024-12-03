package com.pd.server.torrent;

import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.UnaryOperator;

@ApiGroup(path = "tag")
public class TagController {

    @Autowired
    private TagRepo tagRepo;

    @Api(path = "list")
    public List<TagDTO> list() {
        return tagRepo.list(UnaryOperator.identity());
    }

}
