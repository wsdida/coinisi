package com.coinisi.auth.service;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.coinisi.auth.mapper.SysUserMapper;
import com.coinisi.auth.mapper.SysUserRoleMapper;
import com.coinisi.auth.model.SecurityUser;
import com.coinisi.auth.model.SysUser;
import com.coinisi.auth.model.UserDTO;
import com.coinisi.system.api.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private SysUserMapper userMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    private List<UserDTO> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //List<UserDTO> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        SysUser user=userMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername,username));
        List<String> roles =new ArrayList<>();
                sysUserRoleMapper.selectList(new LambdaQueryWrapper<SysUserRole>().select(SysUserRole::getRoleId).eq(SysUserRole::getUserId,user.getId())).stream().forEach(item ->{
                    roles.add(item.getRoleId().toString());
        });

        SecurityUser securityUser = new SecurityUser(new UserDTO(Long.parseLong(user.getId()), user.getUsername(),user.getPassword(),1,roles));
        return securityUser;
    }

}
