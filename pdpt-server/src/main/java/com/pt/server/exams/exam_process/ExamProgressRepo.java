package com.pt.server.exams.exam_process;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

/**
 * 考核进度仓库
 */
@Repository
public interface ExamProgressRepo extends GeneralJpaRepo<ExamProgressPO, ExamProgressDTO, Long> {
}
