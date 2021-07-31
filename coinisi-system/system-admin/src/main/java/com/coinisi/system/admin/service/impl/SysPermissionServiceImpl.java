package com.coinisi.system.admin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.common.core.constant.AuthorityConstant;
import com.coinisi.system.admin.mapper.SysMenuMapper;
import com.coinisi.system.admin.mapper.SysPermissionMapper;
import com.coinisi.system.admin.mapper.SysRoleMenuMapper;
import com.coinisi.system.admin.mapper.SysRolePermissionMapper;
import com.coinisi.system.admin.service.ISysPermissionService;
import com.coinisi.system.api.entity.SysPermission;
import com.coinisi.system.api.entity.SysRoleMenu;
import com.coinisi.system.api.entity.SysRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private  RedisTemplate redisTemplate;
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;
    /**
     * 将权限刷进去redis 做权限验证
     *
     * @return true刷新成功 false刷新失败
     */
    @Override
    public boolean refreshPremission() {
        redisTemplate.delete(AuthorityConstant.AUTH_USER_ROLES);
        List<SysPermission> permissionList=baseMapper.selectListAll();
        Map<String,List<String>> roleMap=new HashMap<>();
        permissionList.stream().forEach(item ->{
                roleMap.put(item.getPerm(),sysRolePermissionMapper.selectList(new LambdaQueryWrapper<SysRolePermission>().select(SysRolePermission::getRoleId).eq(SysRolePermission::getPermissionId,item.getId())).stream().map(SysRolePermission::getRoleId).collect(Collectors.toList()));
                });
         sysMenuMapper.selectListAll().stream().forEach(item ->{
             roleMap.put(item.getPath(),sysRoleMenuMapper.selectList(new LambdaQueryWrapper<SysRoleMenu>().select(SysRoleMenu::getRoleId).eq(SysRoleMenu::getMenuId,item.getId())).stream().map(SysRoleMenu::getRoleId).collect(Collectors.toList()));
         });
        redisTemplate.opsForHash().putAll(AuthorityConstant.AUTH_USER_ROLES,roleMap);
        System.out.println(redisTemplate.opsForHash().entries(AuthorityConstant.AUTH_USER_ROLES).get("/com"));
        return true;
    }
}
