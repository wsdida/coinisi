package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysLog;
import com.coinisi.system.api.entity.SysOperLog;
import com.coinisi.system.api.vo.QueryCommon;

import java.util.List;

/**
 * @author xyqws
 */
public interface ISysOperLogService extends IService<SysOperLog>
{
    /**
     * 查询操作日志记录
     * 
     * @param operId 操作日志记录ID
     * @return 操作日志记录
     */
    public SysOperLog selectOperLogById(Long operId);

    /**
     * 查询操作日志记录列表
     * 
     * @param operLog 操作日志记录
     * @return 操作日志记录集合
     */
    public IPage<SysOperLog> selectOperLogList(SysOperLog operLog, QueryCommon queryCommon);

    /**
     * 新增操作日志记录
     * 
     * @param operLog 操作日志记录
     * @return 结果
     */
    public int insertOperLog(SysOperLog operLog);

    /**
     * 修改操作日志记录
     * 
     * @param operLog 操作日志记录
     * @return 结果
     */
    public int updateOperLog(SysOperLog operLog);

    /**
     * 批量删除操作日志记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOperLogByIds(String ids);

    /**
     * 删除操作日志记录信息
     * 
     * @param operId 操作日志记录ID
     * @return 结果
     */
    public int deleteOperLogById(Long operId);
}
