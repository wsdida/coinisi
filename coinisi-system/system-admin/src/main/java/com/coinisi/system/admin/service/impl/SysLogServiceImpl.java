package com.coinisi.system.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysLogMapper;
import com.coinisi.system.admin.mapper.SysRoleMapper;
import com.coinisi.system.admin.service.ISysLogService;
import com.coinisi.system.admin.service.ISysRoleService;
import com.coinisi.system.api.entity.SysLog;
import com.coinisi.system.api.entity.SysRole;
import com.coinisi.system.api.vo.QueryCommon;
import com.coinisi.system.api.vo.SysSelectTreeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

    @Override
    public IPage<SysLog> querySysLog(QueryCommon queryCommon, SysLog sysLog) {
        IPage<SysLog> page = new Page<>(queryCommon.getCurrent(),queryCommon.getSize());
        return baseMapper.querySysLog(page,sysLog);
    }
}
