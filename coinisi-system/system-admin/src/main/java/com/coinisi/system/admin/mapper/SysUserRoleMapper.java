package com.coinisi.system.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinisi.system.api.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
