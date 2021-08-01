package com.coinisi.system.admin.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.common.core.constant.UserConstant;
import com.coinisi.common.core.util.IdUtils;
import com.coinisi.system.admin.service.ISysMenuService;
import com.coinisi.system.admin.service.ISysRoleMenuService;
import com.coinisi.system.api.entity.SysMenu;
import com.coinisi.system.api.entity.SysRoleMenu;
import com.coinisi.system.api.vo.SysMenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/sys-menu")
@Api(tags = {"菜单接口"})
public class SysMenuController {
    @Autowired
    private ISysMenuService service;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ISysRoleMenuService roleMenuService;

    @ApiOperation(value = "获取树形菜单")
    @GetMapping
    public List<? extends Object> getTreeMenu(SysMenu sysMenu){
        List<Long> authList= (List<Long>) redisTemplate.opsForHash().entries(UserConstant.USER_INFO).get("authorities");
        List<SysMenuVo> sysMenuList = service.selectRoleMenu(authList,sysMenu);
        AtomicBoolean menu = new AtomicBoolean(false);
        sysMenuList.stream().forEach(item ->{
            if("0".equals(item.getParentId())){
                menu.set(true);
            }

        });
        if(menu.get()){
            return sysMenuList.stream().filter(item ->"0".equals(item.getParentId())).map(item -> {
                item.setKey(item.getId());
                item.setChildren(getChildren(item,sysMenuList));
                return item;
            }).collect(Collectors.toList());
        }else {
            System.out.println(sysMenuList);
            return sysMenuList;
        }
    
    }
    public static List<SysMenuVo> getChildren(SysMenuVo sysMenuVo, List<SysMenuVo> voList){
        List<SysMenuVo> s=voList.stream().filter(item -> item.getParentId().equals(sysMenuVo.getId())).map(item ->{
            item.setKey(item.getId());
            item.setChildren(getChildren(item,voList));
            return item;
        }).collect(Collectors.toList());
        return s;
    }
    @ApiOperation(value = "获取下拉树形菜单",httpMethod = "GET")
    @GetMapping("/getSelectTreeMenu")
    public R getSelectTreeMenu(){
        return R.ok(service.selectTreeVo());
    }
    @ApiOperation(value = "添加菜单",httpMethod = "POST")
    @PostMapping
    public R addMenu(  SysMenu menu){
         List<Long> authList= (List) redisTemplate.opsForHash().entries(UserConstant.USER_INFO).get("authorities");
         // 生成id
         Long id = IdUtils.snowflake();
         menu.setId(String.valueOf(id));
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        sysRoleMenu.setMenuId(id.toString());
        sysRoleMenu.setRoleId(String.valueOf(1));
        roleMenuService.save(sysRoleMenu);
        return R.ok(service.save(menu));
    }
    @ApiOperation(value = "删除菜单")
    @DeleteMapping
    public R deleteMenu(@RequestParam("id") String id){
        List ids = Arrays.asList(id.split(","));
        ids.forEach(item->{
            roleMenuService.remove(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getMenuId,item));
        });

        return R.ok(service.removeByIds(ids));
    }
    @ApiOperation(value = "更新菜单")
    @PostMapping("/update")
    public R updateMenu( SysMenu sysMenu){
        service.updateMenu(sysMenu);
        return R.ok("更新成功");
    }


}
