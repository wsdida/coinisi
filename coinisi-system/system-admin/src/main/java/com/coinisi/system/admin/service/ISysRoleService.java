package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysRole;
import com.coinisi.system.api.vo.SysSelectTreeVo;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 查询列表
     * @param sysRole
     * @return
     */
    List<SysRole> queryList(SysRole sysRole);

    /**
     * 查询列表
     * @return
     */
    List<SysSelectTreeVo> selectRole(String  userId);



}
