package com.coinisi.system.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinisi.system.api.entity.SysFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统文件(SysFile)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-10 17:02:52
 */
@Mapper
public interface SysFileMapper extends BaseMapper<SysFile> {


}

