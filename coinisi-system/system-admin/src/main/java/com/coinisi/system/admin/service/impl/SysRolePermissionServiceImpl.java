package com.coinisi.system.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.coinisi.system.admin.mapper.SysRolePermissionMapper;

import com.coinisi.system.admin.service.ISysRolePermissionService;

import com.coinisi.system.api.entity.SysRolePermission;

import org.springframework.stereotype.Service;


/**
 * 角色权限表(SysRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2021-06-22 22:46:59
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {

}
