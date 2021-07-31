package com.coinisi.system.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysRoleMenuMapper;
import com.coinisi.system.admin.service.ISysRoleMenuService;
import com.coinisi.system.api.entity.SysRoleMenu;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

    /**
     * 删除角色与菜单关联
     *
     * @param menuId
     * @param roleId
     */
    @Override
    public void deleteByIds(String menuId, String roleId) {
        baseMapper.deleteByIds(menuId,roleId);
    }
}
