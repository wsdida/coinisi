package com.coinisi.system.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinisi.system.api.entity.SysPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xyqws
 */
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {
    /**
     * 查询部门
     * @param sysPost
     * @return
     */
    List<SysPost> queryPostList(SysPost sysPost);
}
