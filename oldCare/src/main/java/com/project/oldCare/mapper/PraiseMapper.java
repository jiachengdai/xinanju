package com.project.oldCare.mapper;

import com.project.oldCare.entity.Praise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PraiseMapper {

    @Insert("INSERT INTO praise (user_id, create_time, update_time, source_table, source_field, source_id, status)  VALUES (#{userId}, now(), now(), #{sourceTable}, #{sourceField}, #{sourceId}, 1)")
    void newPraise(Praise praise);
    @Select("SELECT * FROM praise  WHERE user_id = #{userId}  AND source_table = #{sourceTable}  AND source_field = #{sourceField}  AND source_id = #{sourceId};")
    Praise findPraiseByIds(Long userId, String sourceTable, String sourceField, Integer sourceId);
    @Update("update  praise set status=#{status},update_time=now() where praise_id=#{praiseId}")
    void updatePraise(Praise praise);
    @Select("SELECT COUNT(*) FROM praise WHERE source_table = #{sourceTable} AND source_field = #{sourceField} AND source_id = #{sourceId} AND status = 1 ")
    Integer praise_len(String sourceTable, String sourceField, Integer sourceId);
}
