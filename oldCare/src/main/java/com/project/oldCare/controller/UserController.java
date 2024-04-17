package com.project.oldCare.controller;

import com.project.oldCare.entity.User;
import com.project.oldCare.service.UserService;
import com.project.oldCare.utils.Result;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^[a-zA-Z0-9]{5,16}$") String username,
                           @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()-_+=]{5,16}$") String password,
                           @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$") String nickname) {

        User user = userService.findByUsername(username);
        if (user == null) {
            userService.register(username, password, nickname,"admin");
            return Result.success();
        } else {
            return Result.error("用户名被占用");
        }
    }



    @PutMapping("/update-admin")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }
@DeleteMapping("/delete")
public  Result deleteUser(@RequestParam Integer id){
        userService.deleteById(id);
        return Result.success();
}
    @PatchMapping("/change-admin-password")
    public Result changePassword(@RequestBody Map<String, String> params, @RequestHeader("Authorization") String token) {
        PasswordEncoder encoder=new BCryptPasswordEncoder();
        String newPassword = params.get("new_password");
        String oldPassword = params.get("old_password");
        String rePassword = params.get("re_password");
        if (!StringUtils.hasLength(oldPassword) || !StringUtils.hasLength(newPassword) || !StringUtils.hasLength(rePassword)) {
            return Result.error("缺少参数");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);

        if (!encoder.matches(newPassword,encoder.encode(oldPassword))) {
            return Result.error("原密码错误！");
        }

        if (!newPassword.equals(rePassword)) {
            return Result.error("两次输入的密码不一致");
        }
         userService.changePassword(encoder.encode(newPassword));

        return Result.success();
    }

    @PatchMapping("/update-avatar")
    public Result updateAvatar(@RequestParam @URL String imgUrl) {

        userService.updateAvatar(imgUrl);
        return Result.success();

    }
    @GetMapping("/getUsername")
    public String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }
    @GetMapping
    public Result getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        return Result.success(user);
    }
    @GetMapping("/findByUsername")
    public Result findByUsername(@RequestParam String username){
        User user  =userService.findByUsername(username);
        List <User>userList=new ArrayList<>();
        userList.add(user);
        return Result.success(userList);
    }







    @GetMapping("/list")
    public Result getlist(){
        List<User>list= userService.getList();
        return Result.success(list);
    }

}
