package com.coinisi.system.admin.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysNotice;

import java.util.List;

/**
 * 通知公告Service接口
 * 
 * @author ruoyi
 * @date 2021-08-03
 */
public interface ISysNoticeService  extends IService<SysNotice>
{
    /**
     * 查询通知公告
     * 
     * @param noticeId 通知公告ID
     * @return 通知公告
     */
    public SysNotice selectNoticeById(Integer noticeId);

    /**
     * 查询通知公告列表
     * 
     * @param notice 通知公告
     * @return 通知公告集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 新增通知公告
     * 
     * @param notice 通知公告
     * @return 结果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改通知公告
     * 
     * @param notice 通知公告
     * @return 结果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 批量删除通知公告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String ids);

    /**
     * 删除通知公告信息
     * 
     * @param noticeId 通知公告ID
     * @return 结果
     */
    public int deleteNoticeById(Integer noticeId);
}
