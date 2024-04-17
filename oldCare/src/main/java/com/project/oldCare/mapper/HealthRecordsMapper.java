package com.project.oldCare.mapper;

import com.project.oldCare.entity.HealthRecords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wangyating
* @description 针对表【health_records(健康记录)】的数据库操作Mapper
* @createDate 2024-03-28 11:59:37
* @Entity com.project.oldcare_demo5.entity.HealthRecords
*/
@Mapper
public interface HealthRecordsMapper extends BaseMapper<HealthRecords> {

}




