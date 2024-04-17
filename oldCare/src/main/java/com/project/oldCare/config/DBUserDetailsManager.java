package com.project.oldCare.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.oldCare.entity.Role;
import com.project.oldCare.entity.User;
import com.project.oldCare.mapper.RoleMapper;
import com.project.oldCare.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;


@Component
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    UserMapper userMapper;

    @Resource
    RoleMapper roleMapper;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库中查询用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //封装查询，根据username
        queryWrapper.eq("user_name",username);
        //从数据库中获取到的user对象；
        User user=userMapper.selectOne(queryWrapper);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        //从数据库中查询角色信息
        QueryWrapper<Role> queryWrapper1 = new QueryWrapper<>();
        //封装查询
        queryWrapper1.eq("id",user.getRoleId());
        //从数据库中获取到的role对象；
        Role role= roleMapper.selectOne(queryWrapper1);


            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUserName())
                    .password(user.getPassword())
                    .disabled(user.getEnable()==0)
                    //凭证是否过期
                    .credentialsExpired(false)
                    //是否被锁定
                    .accountLocked(false)
                    .roles(role.getName())
                    .build();


    }
}
