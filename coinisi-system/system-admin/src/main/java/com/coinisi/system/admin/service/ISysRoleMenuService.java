package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysRoleMenu;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 删除角色与菜单关联
     * @param menuId
     * @param roleId
     */
    void deleteByIds(String menuId,String roleId);

}
