package com.coinisi.system.admin.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysDictItemService;
import com.coinisi.system.api.entity.SysDictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 字典数据表 前端控制器
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/sys-dict-item")
@Api(tags={"字典数据表"})
public class SysDictItemController {
    @Autowired
    private ISysDictItemService service;

    @ApiOperation(value = "查询字典数据 " ,httpMethod = "GET")
    @GetMapping("/queryDictItem")
    public R<List<SysDictItem>> queryDictitem(SysDictItem sysDictItem){
        return R.ok(service.queryDictItem(sysDictItem));
    }
    @ApiOperation(value = "向字典数据表添加数据", httpMethod = "POST")
    @PostMapping("/save")
    public R<Boolean> saveDictItem(SysDictItem sysDictItem){
        return R.ok(service.save(sysDictItem));
    }
    @ApiOperation(value = "更新字典数据表数据", httpMethod = "PUT")
    @PutMapping("/update")
    public R<Boolean> updateDictItem(SysDictItem sysDictItem){
        return R.ok(service.updateById(sysDictItem));
    }
    @ApiOperation(value = "删除典数据表数据", httpMethod = "DELETE")
    @DeleteMapping("/delete")
    public R<Boolean> deleteDictItem(SysDictItem sysDictItem){
        return R.ok(service.removeById(sysDictItem.getId()));
    }


}
