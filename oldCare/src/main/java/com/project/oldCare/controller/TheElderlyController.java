package com.project.oldCare.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.oldCare.entity.CompetencyAssessment;
import com.project.oldCare.entity.TheElderly;
import com.project.oldCare.entity.User;
import com.project.oldCare.mapper.CompetencyAssessmentMapper;
import com.project.oldCare.service.TheElderlyService;
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
@RequestMapping("TheElderly")
public class TheElderlyController {

    @Autowired
    private TheElderlyService theElderlyService;

    @Autowired
    private UserService userService;

    @Resource
    private CompetencyAssessmentMapper competencyAssessmentMapper;

    @Resource
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Result add(@RequestBody @Validated TheElderly theElderly){

        //为新增老人创建用户账号（账号：老人编号，密码：123456）
        User user = new User();
        user.setUserName(theElderly.getSeniorCitizenNumber());
        user.setPassword(passwordEncoder.encode("123456"));
        user.setRoleId(2L);
        user.setNickName(theElderly.getFullName());

        userService.register(user.getUserName(),user.getPassword(),user.getNickName(),"editor");

        //返回所分配账号的编号保存至老人信息
        theElderly.setUserId(userService.getOne(new QueryWrapper<User>().eq("user_name",user.getUserName())).getId());

        //根据新增老人信息更改视图信息
        CompetencyAssessment competencyAssessment=competencyAssessmentMapper.selectById(theElderly.getDisDegree());
        CompetencyAssessment competencyAssessmentS=competencyAssessmentMapper.selectById(4);
        competencyAssessment.setCount(competencyAssessment.getCount()+1);
        competencyAssessmentS.setCount(competencyAssessmentS.getCount()+1);
        competencyAssessmentMapper.updateById(competencyAssessmentS);
        competencyAssessmentMapper.updateById(competencyAssessmentS);


        theElderlyService.save(theElderly);
        return Result.success();
    }
//    @GetMapping("/listByTitle")
//    @PreAuthorize("hasRole('ADMIN')")
//    public Result<IPage<TheElderly>> listByTiTle (@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
//                                              @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
//                                              @RequestParam(value = "name",required = false) String name){
//        QueryWrapper<TheElderly> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("title",name);
//        IPage<TheElderly> page = new Page<>(pageNum,pageSize);
//        return Result.success(theElderlyService.page(page, queryWrapper));
//    }

    @GetMapping("/list")
    public  Result<List<TheElderly>> list(){
        return Result.success(theElderlyService.list());
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Result update(@RequestBody @Validated TheElderly theElderly){
        theElderlyService.updateById(theElderly);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public Result delete(@RequestParam Integer id)
    {
        //根据新增老人信息更改视图信息
         CompetencyAssessment competencyAssessmentS=competencyAssessmentMapper.selectById(4);
         competencyAssessmentS.setCount(competencyAssessmentS.getCount()-1);
        competencyAssessmentMapper.updateById(competencyAssessmentS);
        competencyAssessmentMapper.updateById(competencyAssessmentS);
        theElderlyService.removeById(id);
        return Result.success();
    }
}
