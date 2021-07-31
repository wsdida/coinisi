package com.coinisi.system.admin.controller;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.coinisi.common.core.util.FileUtil;
import com.coinisi.common.core.util.IdUtils;
import com.coinisi.system.admin.service.ISysFileService;
import com.coinisi.system.api.entity.SysFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/common")
@RestController
public class FileController {
    @Value("${spring.file.path.type}")
    private String filePath;
    @Value("${spring.file.url}")
    private String url;
    @Autowired
    private ISysFileService fileService;
    /**
     * 上传
     * @param files
     * @return
     */
    @PostMapping("/file")// 浏览器地址栏输入的路径
    @ResponseBody
    public R uploadVideo2(@RequestParam("file")MultipartFile[] files) throws IOException {
        /**
         * MultipartFile类是用来接收前台传过来的文件，常用的方法如下：
         * String getContentType()          //获取文件MIME类型
         * InputStream getInputStream()     //获取文件流
         * String getName()                 //获取表单中文件组件的名字
         * String getOriginalFilename()     //获取上传文件的原名
         * long getSize()                   //获取文件的字节大小，单位byte，除以1024就是kb
         * boolean isEmpty()                //是否为空
         * void transferTo(File dest)       //保存到一个目标文件中。
         */
        List<SysFile> sysFileList = new ArrayList<>();
        List<String> urlList = new ArrayList<>();
        String filePaths = new String();
       for (MultipartFile file : files) { //因为有上传多个文件，所以用的是MultipartFile[]数组，所以要遍历数组保存里面的每一个文件
            System.out.println(" 文件名称： " + file.getOriginalFilename());
            System.out.println(" 文件名称： " + file.getOriginalFilename().split("\\.")[1]);
            System.out.println(" 文件名称： " + file.getOriginalFilename().split("\\.")[0]);
            System.out.println(" 文件大小： " + file.getSize() / 1024D + "Kb");
            System.out.println(" 文件类型： " + file.getContentType());
            String[] name = file.getOriginalFilename().split("\\.");
            String currentName = IdUtil.fastUUID()+"."+name[name.length-1];
            String path = filePath+currentName;
            file.transferTo(new File(path));
            SysFile sysFile = new SysFile();
            sysFile.setId(String.valueOf(IdUtils.snowflake()));
            sysFile.setCurrentName(currentName);
            sysFile.setName(name[0]);
            sysFile.setIsDelete(2);
            sysFile.setType(FileUtil.getType(path).toString());
            sysFile.setUrl(filePath);
            sysFile.setSize((double) (file.getSize()/1024));
            sysFileList.add(sysFile);
            urlList.add(url+currentName);
        }
        fileService.saveBatch(sysFileList);
        return R.ok(urlList);
    }
}
