package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysUserRole;

import java.util.Map;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * 操作更新用户拥有的权限
     * @param map
     * @return
     */
    Boolean updateUserRole(Map<String,Object> map);
}
