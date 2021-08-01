package com.coinisi.system.admin.controller;


import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.common.core.util.IdUtils;
import com.coinisi.system.admin.service.ISysRoleMenuService;
import com.coinisi.system.admin.service.ISysRoleService;
import com.coinisi.system.admin.service.ISysUserRoleService;
import com.coinisi.system.api.entity.SysRole;
import com.coinisi.system.api.entity.SysRoleMenu;
import com.coinisi.system.api.entity.SysUserRole;
import com.coinisi.system.api.vo.SysSelectTreeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/sys-role")
@Api(tags = {"角色接口"})
public class SysRoleController {

    @Autowired
    private ISysRoleService service;
    @Autowired
    private ISysRoleMenuService sysRoleMenuService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @ApiOperation(value = "查询角色列表")
    @GetMapping
    public R queryRoleList(SysRole sysRole){
        List<SysRole> sysRoleList = service.queryList(sysRole);
        sysRoleList.stream().forEach(item ->{
            item.setMenuIds(sysRoleMenuService.list(new LambdaQueryWrapper<SysRoleMenu>().
                    select(SysRoleMenu::getMenuId).eq(SysRoleMenu::getRoleId,item.getId())).stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList()));
        });

        return R.ok(sysRoleList);
    }
    @ApiOperation(value = "更新角色状态")
    @PostMapping
    public R updateRole(SysRole sysRole){
        return R.ok(service.updateById(sysRole));
    }
    @ApiOperation(value = "更新角色")
    @PostMapping("/update")
    public R update(@RequestParam Map<String,Object> map){
        SysRole sysRole = new SysRole();
        sysRole.setGmtCreate(DateTime.now());
        Long id = Long.parseLong(map.get("id").toString());
        sysRole.setId(String.valueOf(id));
        sysRole.setIdentification(map.get("identification").toString());
        sysRole.setName(map.get("name").toString());
        sysRole.setSort(Integer.parseInt(map.get("sort").toString()));
        sysRole.setStatus(Boolean.parseBoolean(map.get("status").toString()));
        List<String> menuList = Arrays.asList(map.get("menuIds").toString().split(","));
        List<String> roleMenuList = sysRoleMenuService.list(new LambdaQueryWrapper<SysRoleMenu>().select(SysRoleMenu::getMenuId).eq(SysRoleMenu::getRoleId,id)).stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        List<String> addReduce = menuList.stream().filter(item -> !roleMenuList.contains(item)).collect(Collectors.toList());
        List<String> deleteReduce = roleMenuList.stream().filter(item -> !menuList.contains(item)).collect(Collectors.toList());
        List<SysRoleMenu> addSysRoleMenuList = new ArrayList<>();
        for (int i=0;i<addReduce.size();i++) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(String.valueOf(id));
            sysRoleMenu.setMenuId(addReduce.get(i));
            addSysRoleMenuList.add(sysRoleMenu);
        }
        for (int i=0;i<deleteReduce.size();i++) {
            sysRoleMenuService.deleteByIds(deleteReduce.get(i),String.valueOf(id));
        }
        sysRoleMenuService.saveBatch(addSysRoleMenuList);

        return R.ok(service.updateById(sysRole));
    }
    @ApiOperation(value = "添加角色关联菜单",httpMethod = "POST")
    @PostMapping("/save")
    public R insertRole(@RequestParam Map<String,Object> map){
        SysRole sysRole = new SysRole();
        sysRole.setGmtCreate(DateTime.now());
        Long id = IdUtils.snowflake();
        sysRole.setId(String.valueOf(id));
        sysRole.setIdentification(map.get("identification").toString());
        sysRole.setName(map.get("name").toString());
        sysRole.setSort(Integer.parseInt(map.get("sort").toString()));
        sysRole.setStatus(Boolean.parseBoolean(map.get("status").toString()));
        List<String> menuList = Arrays.asList(map.get("menuIds").toString().split(","));
        List<SysRoleMenu> sysRoleMenuList = new ArrayList<>();
        for (int i=0;i<menuList.size();i++) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(String.valueOf(id));
            sysRoleMenu.setMenuId(menuList.get(i));
            sysRoleMenuList.add(sysRoleMenu);
        }
        service.save(sysRole);
       return R.ok(sysRoleMenuService.saveBatch(sysRoleMenuList));
    }

    @ApiOperation(value = "查询角色信息",httpMethod = "GET")
    @GetMapping("/selectRole")
    public R< List<SysSelectTreeVo>> selectRole(@RequestParam String  userId){
        return R.ok(service.selectRole( userId));
    }
    @ApiOperation(value = "删除权限",httpMethod = "DELETE")
    @DeleteMapping("/delete")
    public R<Boolean> deleteRole(@RequestParam String id){
        sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getRoleId,id));
       sysRoleMenuService.remove(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getRoleId,id));
        return R.ok(service.remove(new LambdaQueryWrapper<SysRole>().eq(SysRole::getId,id)));
    }
}
