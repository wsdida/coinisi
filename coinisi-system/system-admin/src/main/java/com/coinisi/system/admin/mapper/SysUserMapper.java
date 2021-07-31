package com.coinisi.system.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinisi.system.api.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> queryUserList(SysUser sysUser);

}
