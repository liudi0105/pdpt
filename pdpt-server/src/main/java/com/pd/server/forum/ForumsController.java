package com.pd.server.forum;

import com.pd.server.forum.overforums.OverForumsDTO;
import com.pd.server.forum.overforums.OverForumsRepo;
import com.pd.server.forum.topics.TopicDTO;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import common.module.webmvc.ValueWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Api(path = "list-topic-by-forum-id")
    public List<TopicDTO> listTopicByForumId(@RequestBody @ValueWrapper.NotNull ValueWrapper<Short> id) {
        return forumsService.listTopicByForumId(id.getValue());
    }
}
