package com.pt.server.exams.exams;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

/**
 * 考核仓库
 */
@Repository
public interface ExamsRepo extends GeneralJpaRepo<ExamsPO, ExamsDTO, Long> {
}
