package com.project.oldCare.mapper;

import com.project.oldCare.entity.HealthRecords;
import org.apache.ibatis.annotations.*;

@Mapper
public interface HealthCordMapper_j {
    @Select("SELECT * FROM health_records WHERE  senior_citizen_number=#{id}")
    HealthRecords getCordById(Integer id);

}
