package com.coinisi.system.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysFile;
import com.coinisi.system.api.vo.QueryCommon;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * 系统文件(SysFile)表服务接口
 *
 * @author makejava
 * @since 2021-07-10 17:02:55
 */
public interface ISysFileService extends IService<SysFile> {
    /**
     * 查询文件分页
     * @param sysFile
     * @param queryCommon
     * @return
     */
    IPage<SysFile> selectFile(SysFile sysFile, QueryCommon queryCommon);

}
