package com.project.oldCare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.oldCare.entity.User;
import com.project.oldCare.mapper.UserMapper_j;
import com.project.oldCare.service.UserService;
import com.project.oldCare.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wangyating
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-03-28 11:59:37
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private UserMapper_j userMapper;

    @Override
    public User findByUsername(String username) {
        User user =userMapper.findByUserName(username);
        return user;
    }

    @Override
    public void register(String username, String password, String nickname, String roles) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String BCPassword=encoder.encode(password);
        String userGroup="ADMIN";

        Long role_id= 1L;
        if(roles.equals("editor")){
            role_id=2L;

        }
        userMapper.add(username,BCPassword,role_id,nickname,roles);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void updateLoginTime(Long userId) {

        userMapper.updateLoginTime(userId);
    }

    @Override
    public void changePassword(String newBCpassword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userMapper.changePassword(newBCpassword,username);
    }

    @Override
    public void updateAvatar(String imgUrl) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userMapper.updateAvatar(imgUrl,username);
    }

    @Override
    public User findByUserId(Long userId) {
        return   userMapper.findByUserId(userId);
    }

    @Override
    public User getNow() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return findByUsername(username);
    }

    @Override
    public void deleteById(Integer id) {
         userMapper.deleteUserById(id);
    }

    @Override
    public List<User> getList() {
        return userMapper.listAll();
    }

}




