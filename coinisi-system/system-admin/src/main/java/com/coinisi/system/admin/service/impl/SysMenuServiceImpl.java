package com.coinisi.system.admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysMenuMapper;
import com.coinisi.system.admin.service.ISysMenuService;
import com.coinisi.system.api.entity.SysMenu;
import com.coinisi.system.api.vo.SysMenuVo;
import com.coinisi.system.api.vo.SysSelectTreeVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<SysMenuVo> selectRoleMenu(List<Long> roleId,SysMenu sysMenu) {
        return baseMapper.selectRoleMenu(roleId,sysMenu);
    }

    /**
     * 树形菜单下拉选择
     *
     * @return
     */
    @Override
    public List<SysSelectTreeVo> selectTreeVo() {
        List<SysSelectTreeVo> treeDeptVo=baseMapper.selectTreeVo();
        return treeDeptVo.stream().filter(item ->"0" .equals( item.getParentId())).map(item -> {
            item.setChildren(SysDeptServiceImpl.getChildrenDept(item,treeDeptVo));
            return item;
        }).collect(Collectors.toList());
    }

    /**
     * 更新菜单
     *
     * @param sysMenu
     */
    @Override
    public void updateMenu(SysMenu sysMenu) {
        baseMapper.updateMenu(sysMenu);
    }
}
