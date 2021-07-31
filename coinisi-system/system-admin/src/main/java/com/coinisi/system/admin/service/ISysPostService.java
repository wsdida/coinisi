package com.coinisi.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysPost;

import java.util.List;

/**
 * 查询部门service
 * @author xyqws
 */
public interface ISysPostService extends IService<SysPost> {
    /**
     * 查询部门
     * @param sysPost
     * @return
     */
    List<SysPost> queryPostList(SysPost sysPost);
}
