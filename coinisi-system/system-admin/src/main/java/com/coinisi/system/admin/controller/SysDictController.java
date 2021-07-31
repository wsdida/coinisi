package com.coinisi.system.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysDictItemService;
import com.coinisi.system.admin.service.ISysDictService;
import com.coinisi.system.api.entity.SysDict;
import com.coinisi.system.api.entity.SysDictItem;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 字典类型表 前端控制器
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/sys-dict")
@Api(tags = {"字典类型"})
public class SysDictController {

    @Autowired
    private ISysDictService service;
    @Autowired
    private ISysDictItemService dictItemService;

   @GetMapping
   public R<List<SysDict>>  queryDict(SysDict sysDict){
       return R.ok(service.queryDictList(sysDict));
   }
   @PostMapping
   public R<Boolean> insertDict(SysDict sysDict){
     return R.ok(service.save(sysDict));
   }

   @PutMapping
   public R<Boolean> updateSysDic(SysDict sysDict){
       System.out.println(sysDict);
       return R.ok(service.updateById(sysDict));
   }

   @DeleteMapping
    public R<Boolean> deleteDict(SysDict sysDict){
            dictItemService.remove(new LambdaQueryWrapper<SysDictItem>().eq(SysDictItem::getDictCode,sysDict.getCode()));
       return R.ok(service.remove(new LambdaQueryWrapper<SysDict>().eq(SysDict::getCode,sysDict.getCode())));
   }
}
