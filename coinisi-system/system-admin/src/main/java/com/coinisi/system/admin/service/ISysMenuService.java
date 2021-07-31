package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysMenu;
import com.coinisi.system.api.vo.SysMenuVo;
import com.coinisi.system.api.vo.SysSelectTreeVo;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 查询全部
     * @return
     */
    List<SysMenuVo> selectRoleMenu(List<Long> roleId,SysMenu sysMenu);

    /**
     * 树形菜单下拉选择
     * @return
     */
    List<SysSelectTreeVo> selectTreeVo();

    /**
     * 更新菜单
     * @param sysMenu
     */
    void updateMenu(SysMenu sysMenu);
}
