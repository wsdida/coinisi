package com.coinisi.system.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coinisi.system.api.entity.SysUser;
import com.coinisi.system.api.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    IPage<SysUserVO> queryUserList(@Param("page") Page<SysUserVO> page , @Param("sysUser") SysUser sysUser);

}
