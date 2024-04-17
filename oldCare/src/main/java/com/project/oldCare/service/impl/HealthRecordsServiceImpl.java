package com.project.oldCare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.oldCare.entity.HealthRecords;
import com.project.oldCare.mapper.HealthCordMapper_j;
import com.project.oldCare.service.HealthRecordsService;
import com.project.oldCare.mapper.HealthRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author wangyating
* @description 针对表【health_records(健康记录)】的数据库操作Service实现
* @createDate 2024-03-28 11:59:37
*/
@Service
public class HealthRecordsServiceImpl extends ServiceImpl<HealthRecordsMapper, HealthRecords>
    implements HealthRecordsService{
    @Autowired
    HealthCordMapper_j healthCordMapperJ;
    @Override
    public HealthRecords getCordById(Integer id) {
       return   healthCordMapperJ.getCordById(id);
    }
}




