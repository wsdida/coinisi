package com.coinisi.system.admin.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysNoticeService;
import com.coinisi.system.api.entity.SysNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;



/**
 * 通知公告Controller
 *
 */
@Controller
@RequestMapping("/sys-notice")
public class SysNoticeController
{

    @Autowired
    private ISysNoticeService noticeService;

    /**
     * 查询通知公告列表
     */

    @PostMapping("/list")
    @ResponseBody
    public R list(SysNotice notice)
    {
        return R.ok(noticeService.list());
    }



    /**
     * 新增保存通知公告
     */

    @PostMapping("/add")
    @ResponseBody
    public R addSave(SysNotice notice)
    {
        return R.ok(noticeService.insertNotice(notice));
    }


    /**
     * 修改保存通知公告
     */
    @PostMapping("/edit")
    @ResponseBody
    public R editSave(SysNotice notice)
    {
        return R.ok(noticeService.updateNotice(notice));
    }

    /**
     * 删除通知公告
     */
    @PostMapping( "/remove")
    @ResponseBody
    public R remove(String ids)
    {
        return R.ok(noticeService.deleteNoticeByIds(ids));
    }
}
