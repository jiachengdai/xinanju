package com.project.oldCare.mapper;

import com.project.oldCare.entity.Forum;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ForumMapper {
    @Insert("INSERT INTO forum (" +
            "    display, user_id, nickname, praise_len, hits, title, keywords, description," +
            "    url, tag, img, content, create_time, update_time, avatar, type" +
            ") " +
            "VALUES (#{display}, #{userId}, #{nickname}, #{praiseLen}, #{hits}, #{title},#{keywords}, #{description}, #{url}, #{tag}, #{img}, #{content}, now(), now(), #{avatar}, #{type}" +
            ")")
    void addForum(Forum forum);

    @Select("select * from forum where forum_id=#{forumId}")
    Forum getForumDetail(Integer forumId);

    @Update("UPDATE forum  SET display = #{display},user_id = #{userId}, nickname = #{nickname}, praise_len = #{praiseLen}, hits = #{hits}, title = #{title}, keywords = #{keywords}, description = #{description}, url = #{url}, tag = #{tag}, img = #{img}, content = #{content}, create_time = now(), update_time =now(),  avatar = #{avatar},  type = #{type} WHERE forum_id = #{forumId}  ")
    void updateForum(Forum forum);
    @Delete("delete from forum where forum_id=#{forumId}")
    void deleteForum(Integer forumId);

    List<Forum> getAllForum(String type, String tag, LocalDateTime expectedTime);
    @Update("update forum set hits=hits+1 where forum_id=#{forumId}")
    void newHit(Integer forumId);
    @Select("select * from forum where forum_id=#{forumId}")
    Forum findForumById(Integer forumId);
}
