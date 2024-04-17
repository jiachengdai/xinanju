package com.project.oldCare.service;

import com.project.oldCare.entity.HealthRecords;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wangyating
* @description 针对表【health_records(健康记录)】的数据库操作Service
* @createDate 2024-03-28 11:59:37
*/
public interface HealthRecordsService extends IService<HealthRecords> {

    HealthRecords getCordById(Integer id);
}
