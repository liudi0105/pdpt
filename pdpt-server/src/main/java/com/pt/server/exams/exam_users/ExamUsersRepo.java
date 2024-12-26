package com.pt.server.exams.exam_users;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

/**
 * 考核用户仓库
 */
@Repository
public interface ExamUsersRepo extends GeneralJpaRepo<ExamUsersPO, ExamUsersDTO, Long> {
}
