package com.coinisi.system.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysUserMapper;
import com.coinisi.system.admin.service.ISysUserService;
import com.coinisi.system.api.entity.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<SysUser> queryUserList(SysUser sysUser) {
        return baseMapper.queryUserList(sysUser);
    }
}
