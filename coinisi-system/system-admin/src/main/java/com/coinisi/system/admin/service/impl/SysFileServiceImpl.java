package com.coinisi.system.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysFileMapper;
import com.coinisi.system.admin.service.ISysFileService;
import com.coinisi.system.api.entity.SysFile;
import com.coinisi.system.api.vo.QueryCommon;
import org.springframework.stereotype.Service;


/**
 * 系统文件(SysFile)表服务实现类
 *
 * @author makejava
 * @since 2021-07-10 17:02:55
 */
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements ISysFileService {

    @Override
    public IPage<SysFile> selectFile(SysFile sysFile, QueryCommon queryCommon) {
        return baseMapper.selectFile(sysFile,new Page<>(queryCommon.getCurrent(), queryCommon.getSize()));
    }
}
