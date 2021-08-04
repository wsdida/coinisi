package com.coinisi.system.admin.controller;



import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysOperLogService;
import com.coinisi.system.api.entity.SysOperLog;
import com.coinisi.system.api.vo.QueryCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;



/**
 * 操作日志记录Controller
 * 
 * @author ruoyi
 * @date 2021-08-03
 */
@Controller
@RequestMapping("/sys-operaLog")
public class SysOperLogController
{


    @Autowired
    private ISysOperLogService operLogService;

    /**
     * 查询操作日志记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public R list(SysOperLog operLog, QueryCommon queryCommon)
    {
        return R.ok(operLogService.selectOperLogList(operLog,queryCommon));
    }

    /**
     * 新增保存操作日志记录
     */
    @PostMapping("/add")
    @ResponseBody
    public R addSave(SysOperLog operLog)
    {
        return R.ok(operLogService.insertOperLog(operLog));
    }



    /**
     * 删除操作日志记录
     */
    @PostMapping( "/remove")
    @ResponseBody
    public R remove(String ids)
    {
        return R.ok(operLogService.deleteOperLogByIds(ids));
    }
}
