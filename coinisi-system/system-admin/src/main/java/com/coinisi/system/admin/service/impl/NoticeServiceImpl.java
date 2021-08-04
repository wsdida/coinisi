package com.coinisi.system.admin.service.impl;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysDeptMapper;
import com.coinisi.system.admin.mapper.SysNoticeMapper;
import com.coinisi.system.admin.service.ISysDeptService;
import com.coinisi.system.admin.service.ISysNoticeService;
import com.coinisi.system.api.entity.SysDept;
import com.coinisi.system.api.entity.SysNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通知公告Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-03
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements ISysNoticeService
{
    @Autowired
    private SysNoticeMapper noticeMapper;

    /**
     * 查询通知公告
     * 
     * @param noticeId 通知公告ID
     * @return 通知公告
     */
    @Override
    public SysNotice selectNoticeById(Integer noticeId)
    {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询通知公告列表
     * 
     * @param notice 通知公告
     * @return 通知公告
     */
    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增通知公告
     * 
     * @param notice 通知公告
     * @return 结果
     */
    @Override
    public int insertNotice(SysNotice notice)
    {
        notice.setCreateTime(new DateTime());
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改通知公告
     * 
     * @param notice 通知公告
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice)
    {
        notice.setUpdateTime(new DateTime());
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除通知公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String ids)
    {
        return noticeMapper.deleteNoticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除通知公告信息
     * 
     * @param noticeId 通知公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeById(Integer noticeId)
    {
        return noticeMapper.deleteNoticeById(noticeId);
    }
}
