package com.pd.server.forum;

import com.pd.server.forum.forums.ForumsDTO;
import com.pd.server.forum.overforums.OverForumsDTO;
import com.pd.server.forum.post.PostsDTO;
import com.pd.server.forum.topics.TopicDTO;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import common.module.webmvc.ValueWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    @Api(path = "get-topic-by-id")
    public TopicDTO getTopicByForumId(@RequestBody @ValueWrapper.NotNull ValueWrapper<Short> id) {
        return forumsService.getTopicById(id.getValue());
    }

    @Api(path = "get-forum-by-forum-id")
    public ForumsDTO getForumByForumId(@RequestBody @ValueWrapper.NotNull ValueWrapper<Short> id) {
        return forumsService.getForumById(id.getValue());
    }

    @Api(path = "list-posts-by-topic-id")
    public List<PostsDTO> listPostsByTopicId(@RequestBody @ValueWrapper.NotNull ValueWrapper<Integer> id) {
        return forumsService.listPostsByTopicId(id.getValue());
    }
}
