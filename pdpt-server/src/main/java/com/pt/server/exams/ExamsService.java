package com.pt.server.exams;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.pt.server.exams.exam_users.ExamUsersRepo;
import com.pt.server.exams.exams.ExamsRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExamsService {

    @Autowired
    @Getter
    private ExamsRepo examsRepo;

    @Autowired
    @Getter
    private ExamUsersRepo examUsersRepo;

}
