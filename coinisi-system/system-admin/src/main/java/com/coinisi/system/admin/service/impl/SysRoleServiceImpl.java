package com.coinisi.system.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysRoleMapper;
import com.coinisi.system.admin.service.ISysRoleService;
import com.coinisi.system.api.entity.SysRole;
import com.coinisi.system.api.vo.SysSelectTreeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    /**
     * 查询列表
     *
     * @param sysRole
     * @return
     */
    @Override
    public List<SysRole> queryList(SysRole sysRole) {
        return baseMapper.queryList(sysRole);
    }
    public  List<SysSelectTreeVo> selectRole(String  userId){
        if(StringUtils.isAnyEmpty(userId)){
           return baseMapper.selectRoleTree();
        }
        return baseMapper.selectRole(userId);
    }
}
