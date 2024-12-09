package com.pd.server.forum;

import com.pd.server.forum.forummods.ForumsModsRepo;
import com.pd.server.forum.forums.ForumsDTO;
import com.pd.server.forum.forums.ForumsEntity;
import com.pd.server.forum.forums.ForumsRepo;
import com.pd.server.forum.overforums.OverForumsDTO;
import com.pd.server.forum.overforums.OverForumsEntity;
import com.pd.server.forum.overforums.OverForumsRepo;
import com.pd.server.forum.topics.TopicDTO;
import com.pd.server.forum.topics.TopicEntity;
import com.pd.server.forum.topics.TopicRepo;
import com.pd.server.user_info.UserDTO;
import com.pd.server.user_info.UserPO;
import com.pd.server.user_info.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Component
public class ForumsService {

    @Autowired
    private ForumsRepo forumsRepo;

    @Autowired
    private OverForumsRepo overForumsRepo;

    @Autowired
    private ForumsModsRepo forumsModsRepo;

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private UserRepo userRepo;

    public List<OverForumsDTO> dataStructure() {
        List<OverForumsDTO> list = overForumsRepo.list(UnaryOperator.identity());
        List<ForumsDTO> list1 = forumsRepo.list(UnaryOperator.identity());
        Map<Short, OverForumsDTO> collect = list.stream().collect(Collectors.toMap(OverForumsDTO::getId, Function.identity()));
        list1.stream().collect(Collectors.groupingBy(ForumsDTO::getForid))
                .forEach((k, v) -> collect.get(k).setForums(v));
        return list;
    }

    public List<TopicDTO> listTopicByForumId(Short id) {
        List<TopicDTO> topicDTOS = topicRepo.listEq(TopicEntity::getForumid, id);
        List<Long> list = topicDTOS.stream().map(TopicDTO::getUserid).map(Long::valueOf).toList();
        Map<Integer, UserDTO> collect = userRepo.listIn(UserPO::getId, list).stream().collect(Collectors.toMap(v -> (int) (long) v.getId(), Function.identity()));
        topicDTOS.forEach(v -> v.setAuthor(collect.get(v.getUserid()).getUsername()));
        return topicDTOS;
    }

    public ForumsDTO getForumById(Short id) {
        ForumsDTO eq = forumsRepo.getEq(ForumsEntity::getId, id);
        OverForumsDTO eq1 = overForumsRepo.getEq(OverForumsEntity::getId, eq.getForid());
        eq.setBlockName(eq1.getName());
        return eq;
    }
}
