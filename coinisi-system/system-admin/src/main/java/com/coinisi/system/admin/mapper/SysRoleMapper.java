package com.coinisi.system.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinisi.system.api.entity.SysRole;
import com.coinisi.system.api.vo.SysSelectTreeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> queryList(SysRole sysRole);

    List<SysSelectTreeVo> selectRole(String  userId);
    List<SysSelectTreeVo> selectRoleTree();
}
