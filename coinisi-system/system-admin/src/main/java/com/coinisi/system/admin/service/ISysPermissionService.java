package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysPermission;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysPermissionService extends IService<SysPermission> {
    /**
     * 将权限刷进去redis 做权限验证
     * @return true刷新成功 false刷新失败
     */
    boolean refreshPremission();

}
