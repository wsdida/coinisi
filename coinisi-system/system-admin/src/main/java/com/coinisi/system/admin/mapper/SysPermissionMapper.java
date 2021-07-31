package com.coinisi.system.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coinisi.system.api.entity.SysPermission;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    @Select(" select id, name,perm,method from sys_permission where type=1 ")
    List<SysPermission> listPermissionRoles();

    List<SysPermission> selectListAll();
    List<SysPermission> list(Page<SysPermission> page, SysPermission permission);

}
