package com.project.oldCare.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.oldCare.entity.Slides;
import com.project.oldCare.service.SlidesService;
import com.project.oldCare.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("slide")
public class SlideController {

    @Resource
    private SlidesService slidesService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Result add(@RequestBody @Validated Slides slides){
        slidesService.save(slides);
        return Result.success();

    }
    @GetMapping("/listByTitle")
    @PreAuthorize("hasRole('ADMIN')")
    public Result<IPage<Slides>> listByTiTle (@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                              @RequestParam(value = "name",required = false) String name){
        QueryWrapper<Slides> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        IPage<Slides> page = new Page<>(pageNum,pageSize);
        return Result.success(slidesService.page(page, queryWrapper));
    }

    @GetMapping("list")

    public  Result<List<Slides>> list(){
        return Result.success(slidesService.list());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Result update(@RequestBody @Validated Slides slides){
        slidesService.updateById(slides);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public Result delete(@RequestParam Integer Id)
    {
        slidesService.removeById(Id);
        return Result.success();
    }


}
