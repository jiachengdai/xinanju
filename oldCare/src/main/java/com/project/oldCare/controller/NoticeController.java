package com.project.oldCare.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.oldCare.entity.Notice;
import com.project.oldCare.service.NoticeService;
import com.project.oldCare.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告：(Notice)表控制层
 *
 */
@RestController
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Result add(@RequestBody @Validated Notice notice){
        noticeService.save(notice);
        return Result.success();

    }
    @GetMapping("/listByTitle")

    public Result<IPage<Notice>> listByTiTle (@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                              @RequestParam(value = "name",required = false) String name){
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        IPage<Notice> page = new Page<>(pageNum,pageSize);
        return Result.success(noticeService.page(page, queryWrapper));
    }

    @GetMapping("list")
    public  Result<List<Notice>> list(){
        return Result.success(noticeService.list());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Result update(@RequestBody @Validated Notice notice){
        noticeService.updateById(notice);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public Result delete(@RequestParam Integer Id)
    {
        noticeService.removeById(Id);
        return Result.success();
    }

}


