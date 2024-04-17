package com.project.oldCare.mapper;

import com.project.oldCare.entity.Article;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ArticleMapper {
     @Insert("INSERT INTO article (title,type,img, content, source,url,tag,description,create_time,update_time) VALUES (#{title},#{type},#{img},#{content},#{source},#{url},#{tag},#{description},now(),now())")
    void add(Article article);

    List<Article> getAllInfo(String type, String tag, LocalDateTime expectedTime);
    @Select("select * from article where article_id=#{articleId}")
    Article getDetail(Integer articleId);

    @Update("UPDATE article  " +
            "SET title = #{title}, type = #{type}, img = #{img}, content = #{content},  " +
            "    source = #{source}, url =#{url}, tag = #{tag}, description = #{description}, " +
            "    update_time = NOW() ,praise_len=#{praiseLen} " +
            "WHERE article_id = #{articleId};")
    void updateArticle(Article article);
    @Delete("delete   from article where article_id=#{articleId}")
    void deleteArticle(Integer articleId);
    @Update("update article set hits=hits+1 where article_id=#{articleId} ")
    void newHit(Integer articleId);
@Select("select * from article where article_id=#{articleId}")
    Article findArticleById(Integer articleId);
}
