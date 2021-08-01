package com.coinisi.system.admin.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysUserMapper;
import com.coinisi.system.admin.service.ISysUserService;
import com.coinisi.system.api.entity.SysUser;
import com.coinisi.system.api.vo.QueryCommon;
import com.coinisi.system.api.vo.SysUserVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    /**
     * 查询用户条件
     *
     * @param sysUser
     * @return
     */
    @Override
    public IPage<SysUserVO> queryUserList(QueryCommon queryCommon , SysUser sysUser) {
        SysUserVO userVO = new SysUserVO();

        Page<SysUserVO> page = new Page(queryCommon.getCurrent(),queryCommon.getSize());
        return baseMapper.queryUserList(page, sysUser);
    }
}
