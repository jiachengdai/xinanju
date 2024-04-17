package com.project.oldCare.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.oldCare.entity.FamilyMembers;
import com.project.oldCare.entity.User;
import com.project.oldCare.service.FamilyMembersService;
import com.project.oldCare.service.UserService;
import com.project.oldCare.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("FamilyMembers")

public class FamilyMembersController {
    @Autowired
    private FamilyMembersService familyMembersService;

    @Autowired
    private UserService userService;

    @Resource
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Result add(@RequestBody @Validated FamilyMembers familyMembers){

        //为新增家属创建用户账号（账号：家属编号，密码：123456）
        User user = new User();
        user.setUserName(familyMembers.getFamilyNumber());
        user.setPassword(passwordEncoder.encode("123456"));
        user.setRoleId(3L);
        user.setNickName(familyMembers.getFullName());
        userService.save(user);

        //返回所分配账号的编号保存至家属信息
        familyMembers.setUserId(userService.getOne(new QueryWrapper<User>().eq("user_name",user.getUserName())).getId());

        familyMembersService.save(familyMembers);
        return Result.success();
    }

    //根据老人编号返回家属信息
    @GetMapping("/listById")

    public Result<IPage<FamilyMembers>> listByTiTle (@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                                  @RequestParam(value = "the_elderly_id",required = false) String id){
        QueryWrapper<FamilyMembers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("the_elderly_id",id);
        IPage<FamilyMembers> page = new Page<>(pageNum,pageSize);
        return Result.success(familyMembersService.page(page, queryWrapper));
    }

    @GetMapping("list")
    public  Result<List<FamilyMembers>> list(){
        return Result.success(familyMembersService.list());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Result update(@RequestBody @Validated FamilyMembers familyMembers){
        familyMembersService.updateById(familyMembers);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public Result delete(@RequestParam Integer Id)
    {
        familyMembersService.removeById(Id);
        return Result.success();
    }
}
