package com.pt.server.category;

import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.UnaryOperator;

@ApiGroup(path = "source")
public class SourceController {

    @Autowired
    private SourceRepo repo;

    @Api(path = "list")
    public List<SourceDTO> list() {
        return repo.list(UnaryOperator.identity());
    }

}
