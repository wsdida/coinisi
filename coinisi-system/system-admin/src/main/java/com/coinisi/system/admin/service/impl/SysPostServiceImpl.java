package com.coinisi.system.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysPostMapper;
import com.coinisi.system.admin.service.ISysPostService;
import com.coinisi.system.api.entity.SysPost;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyqws
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {
    @Override
    public List<SysPost> queryPostList(SysPost sysPost) {
        return baseMapper.queryPostList(sysPost);
    }
}
