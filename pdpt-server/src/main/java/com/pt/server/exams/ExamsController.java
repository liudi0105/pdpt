package com.pt.server.exams;

import com.pt.server.exams.exam_users.ExamUsersDTO;
import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.function.UnaryOperator;

@ApiGroup("exams")
public class ExamsController {

    @Autowired
    private ExamsService examsService;

    @Api("list-exam-users-paged")
    public AppPageResult<ExamUsersDTO> listPaged(@RequestBody AppPageParam pageParam) {
        return examsService.getExamUsersRepo().pageQuery(pageParam, UnaryOperator.identity());
    }

}
