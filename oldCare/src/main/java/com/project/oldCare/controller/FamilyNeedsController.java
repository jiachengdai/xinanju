package com.project.oldCare.controller;


import com.project.oldCare.entity.FamilyNeeds;
import com.project.oldCare.service.FamilyNeedsService;
import com.project.oldCare.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FamilyNeed")
public class FamilyNeedsController {
    @Resource
    private FamilyNeedsService familyNeedsService;


    @PostMapping("/add")
    @PreAuthorize("hasRole('FAMILY')")
    public Result add(@RequestBody @Validated FamilyNeeds familyNeeds){
        familyNeedsService.save(familyNeeds);
        return Result.success();
    }

    @GetMapping("/list")

    public  Result<List<FamilyNeeds>> list(){
        return Result.success(familyNeedsService.list());
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('FAMILY')")
    public Result update(@RequestBody @Validated FamilyNeeds familyNeeds){
        familyNeedsService.updateById(familyNeeds);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('FAMILY')")
    public Result delete(@RequestParam Integer id)
    {
        familyNeedsService.removeById(id);
        return Result.success();
    }
}
