package com.project.oldCare.mapper;

import com.project.oldCare.entity.ArticleType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleTypeMapper {
    @Insert("INSERT INTO article_type (display, name, father_id, description, icon, url, create_time, update_time) " +
            "VALUES (#{display}, #{name}, #{fatherId}, #{description}, #{icon}, #{url}, now(), now()) ")
    void addType(ArticleType articleType);

    List<ArticleType> getAllType();
    @Update("UPDATE article_type SET  display = #{display},  name = #{name}, father_id = #{fatherId}," +
            "    description = #{description}," +
            "    icon = #{icon}," +
            "    url = #{url}," +
            "    update_time = now()" +
            "WHERE type_id = #{typeId}")
    void updateType(ArticleType articleType);
    @Delete("delete from article_type where type_id =#{articleTypeId}")
    void deleteType(Integer articleTypeId);
}
