package com.coinisi.system.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysUserRoleMapper;
import com.coinisi.system.admin.service.ISysUserRoleService;
import com.coinisi.system.api.entity.SysUserRole;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    /**
     * 操作更新用户拥有的权限
     *
     * @param map
     * @return
     */
    @Override
    public Boolean updateUserRole(Map<String, Object> map) {
        if(!map.isEmpty()){
            String userId = map.get("userId").toString();
            baseMapper.delete(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId,userId));
            List<String> menuList = Arrays.asList(map.get("roleIds").toString().split(","));
            for (int i=0; i<menuList.size();i++) {
                SysUserRole userRole = new SysUserRole();
                userRole.setRoleId(menuList.get(i));
                userRole.setUserId(userId);
                baseMapper.insert(userRole);
            }

            return true;
        }
        return false;

    }
}
