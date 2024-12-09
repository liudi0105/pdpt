package com.pd.server.forum;

import com.pd.server.forum.overforums.OverForumsDTO;
import com.pd.server.forum.overforums.OverForumsRepo;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.UnaryOperator;

@ApiGroup(path = "forums")
public class ForumsController {

    @Autowired
    private ForumsService forumsService;

    @Api(path = "forum-structure")
    public List<OverForumsDTO> forumsStructure() {
        return forumsService.dataStructure();
    }
}
