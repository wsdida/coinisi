package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysUser;
import com.coinisi.system.api.vo.QueryCommon;
import com.coinisi.system.api.vo.SysUserVO;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 查询用户条件
     * @param
     * @return
     */
    IPage<SysUserVO> queryUserList(QueryCommon queryCommon , SysUser sysUser);
}
