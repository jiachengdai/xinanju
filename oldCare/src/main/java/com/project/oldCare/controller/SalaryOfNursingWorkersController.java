package com.project.oldCare.controller;


import com.project.oldCare.entity.SalaryOfNursingWorkers;
import com.project.oldCare.service.SalaryOfNursingWorkersService;
import com.project.oldCare.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salary")
public class SalaryOfNursingWorkersController {
    @Resource
    private SalaryOfNursingWorkersService salaryOfNursingWorkersService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Result add(@RequestBody @Validated SalaryOfNursingWorkers salaryOfNursingWorkers){
        salaryOfNursingWorkersService.save(salaryOfNursingWorkers);
        return Result.success();

    }

    @GetMapping("list")
    @PreAuthorize("hasRole('ADMIN')")
    public  Result<List<SalaryOfNursingWorkers>> list(){
        return Result.success(salaryOfNursingWorkersService.list());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Result update(@RequestBody @Validated SalaryOfNursingWorkers salaryOfNursingWorkers){
        salaryOfNursingWorkersService.updateById(salaryOfNursingWorkers);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public Result delete(@RequestParam Integer Id)
    {
        salaryOfNursingWorkersService.removeById(Id);
        return Result.success();
    }
}
