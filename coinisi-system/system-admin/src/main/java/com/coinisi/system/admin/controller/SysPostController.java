package com.coinisi.system.admin.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysPostService;
import com.coinisi.system.api.entity.SysPost;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xyqws
 */
@RestController
@RequestMapping("/sys-post")
@Api(tags = {"部门接口"})
public class SysPostController {
    @Autowired
    private ISysPostService service;

    @ApiOperation(value = "查询部门信息")
    @GetMapping("/queryPost")
    public R<List<SysPost>> queryPost(SysPost sysPost){
        return R.ok(service.queryPostList(sysPost));
    }
    @ApiOperation(value = "更新部门信息")
    @PutMapping("/update")
    public R<Boolean> updatePost(SysPost sysPost){
        return R.ok(service.updateById(sysPost));
    }
    @ApiOperation(value = "插入部门信息")
    @PostMapping("/save")
    public R<Boolean> insertPost(SysPost sysPost){
        return R.ok(service.save(sysPost));
    }
    @ApiOperation(value = "删除部门信息")
    @DeleteMapping("/delete")
    public R<Boolean> deletePost(SysPost sysPost){
        return R.ok(service.removeById(sysPost.getPostId()));
    }

}
