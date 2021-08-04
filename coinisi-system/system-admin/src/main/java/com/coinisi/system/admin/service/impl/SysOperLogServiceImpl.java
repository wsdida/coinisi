package com.coinisi.system.admin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysOperLogMapper;
import com.coinisi.system.admin.mapper.SysPermissionMapper;
import com.coinisi.system.admin.service.ISysOperLogService;
import com.coinisi.system.api.entity.SysOperLog;

import com.coinisi.system.api.entity.SysPermission;
import com.coinisi.system.api.vo.QueryCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作日志记录Service业务层处理

 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements ISysOperLogService
{
    @Autowired
    private SysOperLogMapper operLogMapper;

    /**
     * 查询操作日志记录
     * 
     * @param operId 操作日志记录ID
     * @return 操作日志记录
     */
    @Override
    public SysOperLog selectOperLogById(Long operId)
    {
        return operLogMapper.selectSysOperLogById(operId);
    }

    /**
     * 查询操作日志记录列表
     * 
     * @param operLog 操作日志记录
     * @return 操作日志记录
     */
    @Override
    public IPage<SysOperLog> selectOperLogList(SysOperLog operLog, QueryCommon queryCommon)
    {
        IPage<SysOperLog> page = new Page<>(queryCommon.getCurrent(), queryCommon.getSize());
        return operLogMapper.selectSysOperLogList(page,operLog);
    }

    /**
     * 新增操作日志记录
     * 
     * @param operLog 操作日志记录
     * @return 结果
     */
    @Override
    public int insertOperLog(SysOperLog operLog)
    {
        return operLogMapper.insertSysOperLog(operLog);
    }

    /**
     * 修改操作日志记录
     * 
     * @param operLog 操作日志记录
     * @return 结果
     */
    @Override
    public int updateOperLog(SysOperLog operLog)
    {
        return operLogMapper.updateSysOperLog(operLog);
    }

    /**
     * 删除操作日志记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOperLogByIds(String ids)
    {
        return operLogMapper.deleteSysOperLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除操作日志记录信息
     * 
     * @param operId 操作日志记录ID
     * @return 结果
     */
    @Override
    public int deleteOperLogById(Long operId)
    {
        return operLogMapper.deleteSysOperLogById(operId);
    }
}
