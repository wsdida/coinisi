package com.coinisi.system.admin.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coinisi.common.core.constant.UserConstant;
import com.coinisi.system.admin.service.ISysUserService;
import com.coinisi.system.api.entity.SysUser;
import com.coinisi.system.api.vo.QueryCommon;
import com.coinisi.system.api.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.sql.Wrapper;
import java.util.Arrays;
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
    public  R deleteUser(@RequestParam("id") String id){
        return R.ok(service.removeByIds(Arrays.asList(id.split(","))));
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
    public R<IPage<SysUserVO>> queryUserList(SysUser sysUser, QueryCommon queryCommon){

        return R.ok(service.queryUserList(queryCommon,sysUser));
    }

    public static void main(String[] args) {
        String a ="1";
        System.out.println();
    }
}
