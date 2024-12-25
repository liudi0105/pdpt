package com.pt.server.auth.permissions;

import common.module.jpa.GeneralJpaRepo;

/**
 * 仓库接口：权限
 */
public interface PermissionsRepo extends GeneralJpaRepo<PermissionsPO, PermissionsDTO, Long> {
}