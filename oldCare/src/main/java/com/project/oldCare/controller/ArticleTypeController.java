package com.project.oldCare.controller;

import com.project.oldCare.entity.ArticleType;
import com.project.oldCare.entity.PageBean;
import com.project.oldCare.service.ArticleTypeService;
import com.project.oldCare.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type")

public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Result addType(@RequestBody @Validated ArticleType articleType){
        articleTypeService.addType(articleType);
        return Result.success();
    }
    @GetMapping("/getAllType")
    public Result<PageBean<ArticleType>>getAllType (Integer page, Integer pageSize ){
        PageBean<ArticleType>pb=articleTypeService.getAllType(page,pageSize );
        return Result.success(pb);
    }
    @PutMapping("/updateType")
    @PreAuthorize("hasRole('ADMIN')")
    public Result updateType(@RequestBody @Validated ArticleType articleType){
        articleTypeService.updateType(articleType);
        return Result.success();
    }
    @DeleteMapping("/deleteType")
    @PreAuthorize("hasRole('ADMIN')")
    public Result deleteType(@RequestParam Integer articleTypeId)
    {
        articleTypeService.deleteType(articleTypeId);
        return Result.success();
    }
}
