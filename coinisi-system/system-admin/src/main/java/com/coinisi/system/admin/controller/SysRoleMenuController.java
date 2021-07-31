package com.coinisi.system.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysRoleMenuService;
import com.coinisi.system.api.entity.SysRoleMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 前端控制器
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/sys-role-menu")
@Api(tags = {"角色和菜单关联表 前端控制器"})
public class SysRoleMenuController {

    @Autowired
    private ISysRoleMenuService service;

    @ApiOperation(value = "获取角色菜单集合", httpMethod = "GET")
    @GetMapping("/queryRoleMenu")
    public R<List<SysRoleMenu>> queryRoleMenu(SysRoleMenu sysRoleMenu){
        return R.ok(service.list(new LambdaQueryWrapper<SysRoleMenu>().select(SysRoleMenu::getMenuId).eq(SysRoleMenu::getRoleId,sysRoleMenu.getRoleId())));
    }


}
