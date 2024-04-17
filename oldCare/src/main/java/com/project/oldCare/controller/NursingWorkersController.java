package com.project.oldCare.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.oldCare.entity.NursingWorkers;
import com.project.oldCare.entity.User;
import com.project.oldCare.service.NursingWorkersService;
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
@RequestMapping("NursingWorkers")
public class NursingWorkersController {
    @Autowired
    private NursingWorkersService nursingWorkersService;

    @Autowired
    private UserService userService;

    @Resource
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Result add(@RequestBody @Validated NursingWorkers nursingWorkers){

        //为新增护工创建用户账号（账号：护工编号，密码：123456）
        User user = new User();
        user.setUserName(nursingWorkers.getNurseNo());
        user.setRoleId(4L);
        user.setNickName(nursingWorkers.getFullName());
        user.setPassword(passwordEncoder.encode("123456"));
        userService.save(user);

        //返回所分配账号的编号保存至护工信息
        nursingWorkers.setUserId(userService.getOne(new QueryWrapper<User>().eq("user_name",user.getUserName())).getId());

        nursingWorkersService.save(nursingWorkers);
        return Result.success();
    }

    //根据老人编号查询护工信息
    @GetMapping("/listById")

    public Result<IPage<NursingWorkers>> listByTiTle (@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                                  @RequestParam(value = "the_elderly_id",required = false) String id){
        QueryWrapper<NursingWorkers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("the_elderly_id",id);
        IPage<NursingWorkers> page = new Page<>(pageNum,pageSize);
        return Result.success(nursingWorkersService.page(page, queryWrapper));
    }

    @GetMapping("list")
    public  Result<List<NursingWorkers>> list(){
        return Result.success(nursingWorkersService.list());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Result update(@RequestBody @Validated NursingWorkers nursingWorkers){
        nursingWorkersService.updateById(nursingWorkers);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public Result delete(@RequestParam Integer Id)
    {
        nursingWorkersService.removeById(Id);
        return Result.success();
    }
}
