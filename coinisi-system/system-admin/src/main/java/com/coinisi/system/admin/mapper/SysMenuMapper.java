package com.coinisi.system.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinisi.system.api.entity.SysMenu;
import com.coinisi.system.api.vo.SysMenuVo;
import com.coinisi.system.api.vo.SysSelectTreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询所有菜单
     * @return
     */
    List<SysMenuVo> selectListAll();

    List<SysMenuVo> selectRoleMenu(@Param("list") List<Long> list,@Param("sysMenu")SysMenu sysMenu);

    /**
     * 获取菜单信息
     * @return
     */
    List<SysSelectTreeVo> selectTreeVo();
    /**
     * 更新菜单
     * @return
     */
    void updateMenu(SysMenu sysMenu);
}
