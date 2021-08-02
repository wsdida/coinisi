package com.coinisi.system.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.coinisi.system.api.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xyqws
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {
    IPage<SysLog> querySysLog(@Param("page")  IPage<SysLog> page,@Param("sysLog")  SysLog sysLog);
}
