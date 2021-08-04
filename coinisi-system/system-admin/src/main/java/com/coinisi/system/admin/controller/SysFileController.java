package com.coinisi.system.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.system.admin.service.ISysFileService;
import com.coinisi.system.api.entity.SysFile;
import com.coinisi.system.api.vo.QueryCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 系统文件(SysFile)表控制层
 *
 * @author makejava
 * @since 2021-07-10 17:02:56
 */
@RestController
@RequestMapping("/sys-file")
public class SysFileController {
    @Autowired
    private ISysFileService fileService;

    @GetMapping("/list")
    public R<IPage<SysFile>> list(SysFile sysFile, QueryCommon queryCommon){
        return R.ok(fileService.selectFile(sysFile,queryCommon));
    }
    @DeleteMapping("/delete")
    public R<Boolean> deleteFile(String ids){
        List<String> idList = Arrays.asList(ids.split(","));
        List<SysFile> sysFiles = fileService.listByIds(idList);
        // 删除文件信息
        fileService.removeByIds(idList);
        return R.ok(true);

    }

}
