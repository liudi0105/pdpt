package com.pd.server.forum;

import com.pd.server.forum.forummods.ForumsModsRepo;
import com.pd.server.forum.forums.ForumsDTO;
import com.pd.server.forum.forums.ForumsRepo;
import com.pd.server.forum.overforums.OverForumsDTO;
import com.pd.server.forum.overforums.OverForumsRepo;
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

    public List<OverForumsDTO> dataStructure() {
        List<OverForumsDTO> list = overForumsRepo.list(UnaryOperator.identity());
        List<ForumsDTO> list1 = forumsRepo.list(UnaryOperator.identity());
        Map<Short, OverForumsDTO> collect = list.stream().collect(Collectors.toMap(OverForumsDTO::getId, Function.identity()));
        list1.stream().collect(Collectors.groupingBy(ForumsDTO::getForid))
                .forEach((k,v) -> collect.get(k).setForums(v));
        return list;
    }
}
