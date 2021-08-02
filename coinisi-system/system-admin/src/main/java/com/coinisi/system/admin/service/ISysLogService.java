package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysLog;
import com.coinisi.system.api.entity.SysRole;
import com.coinisi.system.api.vo.QueryCommon;
import com.coinisi.system.api.vo.SysSelectTreeVo;

import java.util.List;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysLogService extends IService<SysLog> {
    /**
     * 日志分页
     * @param queryCommon
     * @param sysLog
     * @return
     */
    IPage<SysLog> querySysLog(QueryCommon queryCommon, SysLog sysLog);





}
