package com.coinisi.system.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysLogService;
import com.coinisi.system.api.entity.SysLog;
import com.coinisi.system.api.vo.QueryCommon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author xyqws
 */
@RequestMapping("/sys-log")
@RestController
@Api(tags = "日志表")
public class SysLogController {
    @Autowired
    private   ISysLogService service;

    @ApiOperation(value = "查询日志详情" , httpMethod = "GET")
    @GetMapping("/list")
    public R<IPage<SysLog>> list(SysLog sysLog, QueryCommon queryCommon){
        return R.ok(service.querySysLog(queryCommon, sysLog));
    }
    @ApiOperation(value = "查询日志详情" , httpMethod = "DELETE")
    @DeleteMapping("/removes")
    public R<Boolean> removes(@RequestParam String ids){
        return R.ok(service.removeByIds(Arrays.asList(ids.split(","))));
    }

}
