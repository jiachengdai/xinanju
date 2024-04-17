package com.project.oldCare.mapper;

import com.project.oldCare.entity.User;
import com.project.oldCare.handler.StringToListHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper_j {
    @Select("SELECT * FROM user WHERE user_name =#{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "enable", column = "enable"),
            @Result(property = "email", column = "email"),
            @Result(property = "phonenumber", column = "phonenumber"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateBy", column = "update_by"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "delFlag", column = "del_flag"),
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roles", column = "roles", typeHandler = StringToListHandler.class) // 使用自定义的类型处理器
    })
    User findByUserName(String username);
    @Insert("INSERT INTO user (user_name, password,create_time,role_id,nick_name,roles) VALUES (#{username},#{BCPassword},now(),#{roleId},#{nickname},#{roles})")
    void add(String username, String BCPassword, Long roleId, String nickname, String roles);
    @Update("UPDATE user SET update_time =now() where id=#{userId}")
    void updateLoginTime(Long userId);
    @Update("update user set avatar=#{avatar}, phonenumber=#{phonenumber},nick_name=#{nickName},email=#{email},enable=#{enable},sex=#{sex},update_time=now()  where id=#{id}")
    void update(User user);
    @Update("UPDATE user set password=#{newBCpassword} where user_name=#{username} ")
    void changePassword(String newBCpassword, String username);
    @Update("update user set avatar=#{imgUrl} where user_name=#{username}")
    void updateAvatar(String imgUrl, String username);
    @Select("select * from user where id=#{userId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "enable", column = "enable"),
            @Result(property = "email", column = "email"),
            @Result(property = "phonenumber", column = "phonenumber"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateBy", column = "update_by"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "delFlag", column = "del_flag"),
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roles", column = "roles", typeHandler = StringToListHandler.class) // 使用自定义的类型处理器
    })
    User findByUserId(Long userId);

    @Delete("delete  from user where id=#{userId}")
    void deleteUserById(Integer id);
    @Select("select * from user where role_id=1")
    List<User> listAll();
}
