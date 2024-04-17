package com.project.oldCare.controller;

import com.project.oldCare.entity.DrugManagement;
import com.project.oldCare.service.DrugManagementService;
import com.project.oldCare.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drug")
public class DrugManagementController {
    @Resource
    private DrugManagementService drugManagementService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Result add(@RequestBody @Validated DrugManagement drugManagement){
        drugManagementService.save(drugManagement);
        return Result.success();

    }

    @GetMapping("list")
    @PreAuthorize("hasAnyRole('ADMIN','NURSE')")
    public  Result<List<DrugManagement>> list(){
        return Result.success(drugManagementService.list());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Result update(@RequestBody @Validated DrugManagement drugManagement){
        drugManagementService.updateById(drugManagement);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public Result delete(@RequestParam Integer Id)
    {
        drugManagementService.removeById(Id);
        return Result.success();
    }

}
