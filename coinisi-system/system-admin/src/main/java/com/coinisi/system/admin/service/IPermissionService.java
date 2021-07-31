package com.coinisi.system.admin.service;

/**
 * 权限接口服务类
 * @author ws
 * @since 2021-05-31
 */
public interface IPermissionService  {

    /**
     * 刷新权限缓存
     * @return true 刷新成功 false刷新失败
     */
    boolean refreshPermissionCatch();
}
