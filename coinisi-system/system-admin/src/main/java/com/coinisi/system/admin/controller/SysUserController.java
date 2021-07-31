package com.coinisi.system.admin.controller;



import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.common.core.constant.UserConstant;
import com.coinisi.system.admin.service.ISysUserService;
import com.coinisi.system.api.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/sys-user")
@Api(tags = {"用户接口"})
public class SysUserController {

    @Autowired
    private ISysUserService service;
    @Autowired
    private RedisTemplate redisTemplate;
    @ApiOperation(value = "获取用户信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "实体类User", required = true, dataType = "sysUser"),
    })
    @GetMapping("/getUser")
    public R getUser(){
        return R.ok(service.getById((Serializable) redisTemplate.opsForHash().entries(UserConstant.USER_INFO).get("id")));
    }
    @ApiOperation(value = "添加 用户信息",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "实体类User", required = true, dataType = "sysUser"),
    })
    @PostMapping
    public R addUser( SysUser user){
        return R.ok(service.save(user));
    }
    @ApiOperation(value = "删除用户信息",httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "用户id", value = "id", required = true, dataType = "long"),
    })
    @GetMapping("/delete")
    public  R deleteUser(@RequestParam("id") Integer id){
        return R.ok(service.removeById(id));
    }
    @ApiOperation(value = "更新用户信息",httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "实体类User", required = true, dataType = "sysUser"),
    })
    @PutMapping
    public R updateUser(SysUser user){
        return R.ok(service.updateById(user));
    }

    @ApiOperation(value = "查询用户信息",httpMethod = "GET")
    @GetMapping("/queryUser")
    public R<List<SysUser>> queryUserList(SysUser sysUser){
        return R.ok(service.queryUserList(sysUser));
    }

}
