package com.coinisi.system.admin.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysDeptService;
import com.coinisi.system.api.entity.SysDept;
import com.coinisi.system.api.vo.SysDeptVo;
import com.coinisi.system.api.vo.SysSelectTreeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@RestController
    @RequestMapping("/sys-dept")
@Api(tags = {"部门接口"})
public class SysDeptController {
    @Autowired
    private  ISysDeptService service;

    @ApiOperation(value = "部门树形结构", httpMethod = "GET")
    @GetMapping("/tree")
    public R<List<SysDeptVo>> getTreeDept(@RequestParam Map<String,Object> map){
        SysDeptVo sysDeptVo = new SysDeptVo();
        if(map.get("name") != null){
            sysDeptVo.setName(map.get("name").toString());
        }
       if(map.get("status") != null){
           sysDeptVo.setStatus(Boolean.valueOf(map.get("status").toString()));
       }

        return R.ok(service.treeDept(sysDeptVo));
    }
    @ApiOperation(value = "部门下拉框树形结构", httpMethod = "GET")
    @GetMapping("/getTree")
    public R<List<SysSelectTreeVo>> getSelectTreeDept(){
        return R.ok(service.treeDeptVo());
    }
    @ApiOperation(value = "添加部门", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysDept", value = "实体JSON对象", required = true, paramType = "body", dataType = "SysDept")
    })
    @PostMapping("/add")
    public R addDept( SysDept sysDept){
        return R.ok(service.save(sysDept));
    }

    @PostMapping("/update")
    public R updateDept(SysDept sysDept){
        return R.ok(service.updateById(sysDept));
    }

    @ApiOperation(value = "删除部门信息", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门id", required = true, paramType = "path", dataType = "Long"),
    })
    @DeleteMapping("/delete")
    public R delete(@PathVariable Long id){
        return R.ok(service.removeById(id));
    }




}
