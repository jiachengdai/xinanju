package com.project.oldCare.controller;


import com.project.oldCare.entity.*;
import com.project.oldCare.mapper.ServiceNumberMapper;
import com.project.oldCare.service.NeedsOfTheElderlyService;
import com.project.oldCare.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ElderlyNeed")
public class NeedOfTheElderlyController {

    @Resource
    private NeedsOfTheElderlyService needsOfTheElderlyService;

    @Resource
    private ServiceNumberMapper serviceNumberMapper;

    @Resource
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/add")
    @PreAuthorize("hasRole('THEELDLY')")
    public Result add(@RequestBody @Validated NeedsOfTheElderly needsOfTheElderly){

        //根据新增需求信息更改视图信息
        ServiceNumber serviceNumber=serviceNumberMapper.selectById(needsOfTheElderly.getNeedId());
        serviceNumber.setCount(serviceNumber.getCount()+1);
        serviceNumberMapper.updateById(serviceNumber);

        needsOfTheElderlyService.save(needsOfTheElderly);
        return Result.success();
    }

    @GetMapping("/list")

    public  Result<List<NeedsOfTheElderly>> list(){
        return Result.success(needsOfTheElderlyService.list());
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('THEELDLY')")
    public Result update(@RequestBody @Validated NeedsOfTheElderly needsOfTheElderly){
        needsOfTheElderlyService.updateById(needsOfTheElderly);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('THEELDLY')")
    public Result delete(@RequestParam Integer id)
    {
        needsOfTheElderlyService.removeById(id);
        return Result.success();
    }

}
