package com.coinisi.system.admin.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.coinisi.system.api.entity.SysOperLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作日志记录Mapper接口

 */
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog>
{
    /**
     * 查询操作日志记录
     * 
     * @param operId 操作日志记录ID
     * @return 操作日志记录
     */
    public SysOperLog selectSysOperLogById(Long operId);

    /**
     * 查询操作日志记录列表
     * 
     * @param sysOperLog 操作日志记录
     * @return 操作日志记录集合
     */
    public IPage<SysOperLog> selectSysOperLogList(@Param("page") IPage<SysOperLog> page,@Param("sysOperLog") SysOperLog sysOperLog);

    /**
     * 新增操作日志记录
     * 
     * @param sysOperLog 操作日志记录
     * @return 结果
     */
    public int insertSysOperLog(SysOperLog sysOperLog);

    /**
     * 修改操作日志记录
     * 
     * @param sysOperLog 操作日志记录
     * @return 结果
     */
    public int updateSysOperLog(SysOperLog sysOperLog);

    /**
     * 删除操作日志记录
     * 
     * @param operId 操作日志记录ID
     * @return 结果
     */
    public int deleteSysOperLogById(Long operId);

    /**
     * 批量删除操作日志记录
     * 
     * @param operIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysOperLogByIds(String[] operIds);
}
