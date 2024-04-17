package com.project.oldCare.mapper;

import com.project.oldCare.entity.Hits;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HitsMapper {
    @Insert("INSERT INTO hits (user_id, source_table, source_field, source_id,update_time,create_time)  VALUES (#{userId}, #{sourceTable}, #{sourceField}, #{sourceId},now(),now())")
    void newHit(Hits hits);
}
