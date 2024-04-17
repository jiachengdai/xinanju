package com.project.oldCare.controller;

import com.project.oldCare.entity.HealthRecords;
import com.project.oldCare.service.HealthRecordsService;
import com.project.oldCare.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HealthRecord")
public class HealthRecordController {

    @Resource
    private HealthRecordsService healthRecordsService;


    @PostMapping("/add")

    public Result add(@RequestBody @Validated HealthRecords healthRecords){

        healthRecordsService.save(healthRecords);
        return Result.success();
    }
   @GetMapping("/detail")
   @PreAuthorize("hasAnyRole('THEELDLY', 'ADMIN')")
   public Result getById(@RequestParam Integer seniorCitizenNumber){
     HealthRecords records=  healthRecordsService.getCordById(seniorCitizenNumber);
     return  Result.success(records);
   }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public  Result<List<HealthRecords>> list(){
        return Result.success(healthRecordsService.list());
    }

    @PutMapping("/update")

    public Result update(@RequestBody @Validated HealthRecords healthRecords){
        healthRecordsService.updateById(healthRecords);
        return Result.success();
    }
    @DeleteMapping("/delete")

    public Result delete(@RequestParam Integer id)
    {
        healthRecordsService.removeById(id);
        return Result.success();
    }

}
