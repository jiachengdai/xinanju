package com.project.oldCare.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.project.oldCare.mapper.CompetencyAssessmentMapper;
import com.project.oldCare.mapper.ElderlyTypeMapper;
import com.project.oldCare.mapper.ServiceNumberMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echarts")
public class EchartsController {

    @Resource
    ElderlyTypeMapper elderlyTypeMapper;

    @Resource
    CompetencyAssessmentMapper competencyAssessmentMapper;

    @Resource
    ServiceNumberMapper serviceNumberMapper;

    @GetMapping("/pie")
    public Object pie(){
        return elderlyTypeMapper.selectList(Wrappers.lambdaQuery());
    }

    @GetMapping("/dash")
    public Object dash(){
        return competencyAssessmentMapper.selectList(Wrappers.lambdaQuery());
    }

    @GetMapping("/Col")
    public Object Col(){
        return serviceNumberMapper.selectList(Wrappers.lambdaQuery());
    }

}
