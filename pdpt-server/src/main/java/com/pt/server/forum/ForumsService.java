package com.pt.server.forum;

import com.pt.server.auth.users.UsersDTO;
import com.pt.server.auth.users.UsersPO;
import com.pt.server.auth.users.UsersRepo;
import com.pt.server.forum.forummods.ForumsModsRepo;
import com.pt.server.forum.forums.ForumsDTO;
import com.pt.server.forum.forums.ForumsEntity;
import com.pt.server.forum.forums.ForumsRepo;
import com.pt.server.forum.overforums.OverForumsDTO;
import com.pt.server.forum.overforums.OverForumsEntity;
import com.pt.server.forum.overforums.OverForumsRepo;
import com.pt.server.forum.post.PostsDTO;
import com.pt.server.forum.post.PostsEntity;
import com.pt.server.forum.post.PostsRepo;
import com.pt.server.forum.topics.TopicDTO;
import com.pt.server.forum.topics.TopicEntity;
import com.pt.server.forum.topics.TopicRepo;
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
    private UsersRepo usersRepo;

    @Autowired
    private PostsRepo postsRepo;

    public List<PostsDTO> listPostsByTopicId(Integer id) {
        List<PostsDTO> postsDTOS = postsRepo.listQuery(v -> v
                .orderBy(PostsEntity::getAdded)
                .asc()
                .where(c -> c.eq(PostsEntity::getTopicid, id)));
        setPostsUser(postsDTOS);
        return postsDTOS;
    }

    private void setPostsUser(List<PostsDTO> postsDTOS) {
        List<Long> list = postsDTOS.stream().map(PostsDTO::getUserid).map(Long::valueOf).toList();
        Map<Long, UsersDTO> collect = usersRepo.listIn(UsersPO::getId, list).stream().collect(Collectors.toMap(UsersDTO::getId, Function.identity()));
        postsDTOS.forEach(v -> v.setUsername(collect.get(v.getUserid().longValue()).getUsername()));
    }

    public List<OverForumsDTO> dataStructure() {
        List<OverForumsDTO> list = overForumsRepo.list(UnaryOperator.identity());
        List<ForumsDTO> list1 = forumsRepo.list(UnaryOperator.identity());
        Map<Short, OverForumsDTO> collect = list.stream().collect(Collectors.toMap(OverForumsDTO::getId, Function.identity()));
        list1.stream().collect(Collectors.groupingBy(ForumsDTO::getForid))
                .forEach((k, v) -> collect.get(k).setForums(v));
        return list;
    }

    public List<TopicDTO> listTopicByForumId(Short id) {
        List<TopicDTO> topicDTOS = topicRepo.listQuery(v -> v
                .asc()
                .where(c -> c.eq(TopicEntity::getForumid, id)));
        List<Long> list = topicDTOS.stream().map(TopicDTO::getUserid).map(Long::valueOf).toList();
        Map<Integer, UsersDTO> collect = usersRepo.listIn(UsersPO::getId, list).stream().collect(Collectors.toMap(v -> (int) (long) v.getId(), Function.identity()));
        topicDTOS.forEach(v -> v.setAuthor(collect.get(v.getUserid()).getUsername()));
        return topicDTOS;
    }

    public TopicDTO getTopicById(Short id) {
        TopicDTO eq = topicRepo.getEq(TopicEntity::getId, id);
        Short forumid = eq.getForumid();
        ForumsDTO forumById = getForumById(forumid);
        eq.setBlockName(forumById.getBlockName())
                .setForumName(forumById.getName());
        return eq;
    }

    public ForumsDTO getForumById(Short id) {
        ForumsDTO eq = forumsRepo.getEq(ForumsEntity::getId, id);
        OverForumsDTO eq1 = overForumsRepo.getEq(OverForumsEntity::getId, eq.getForid());
        eq.setBlockName(eq1.getName());
        return eq;
    }
}
