package com.pt.server.bonus.attendance;


import common.module.jpa.GeneralJpaRepo;

/**
 * 用户签到表的数据库接口
 */
public interface AttendanceRepository extends GeneralJpaRepo<AttendancePO, AttendanceDTO, Long> {
}