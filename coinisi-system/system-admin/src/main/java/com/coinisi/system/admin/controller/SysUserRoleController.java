package com.coinisi.system.admin.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysUserRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 用户和角色关联表 前端控制器
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/sys-user-role")
public class SysUserRoleController {

    @Autowired
    private ISysUserRoleService service;

    @ApiOperation(value = "更新用户信角色息",httpMethod = "POST")
    @PostMapping("/updateUserRole")
    public R updateUserRole(@RequestParam Map<String,Object> map){
       return R.ok(service.updateUserRole(map));
    }

}
