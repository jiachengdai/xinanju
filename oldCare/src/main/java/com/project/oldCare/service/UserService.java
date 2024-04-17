package com.project.oldCare.service;

import com.project.oldCare.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wangyating
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-03-28 11:59:37
*/
public interface UserService extends IService<User> {

    User findByUsername(String username);

    void register(String username, String password, String nickname, String admin);

    void update(User user);

    void updateLoginTime(Long userId);

    void changePassword(String newMd5password);

    void updateAvatar(String imgUrl);

    User findByUserId(Long userId);

    User getNow();

    void deleteById(Integer id);

    List<User> getList();
}
