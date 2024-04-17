package com.project.oldCare.mapper;

import com.project.oldCare.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert(" INSERT INTO comment (user_id, reply_to_id, content, nickname, avatar, create_time, update_time, source_table, source_field, source_id)   VALUES (#{userId}, #{replyToId}, #{content}, #{nickname}, #{avatar}, now(),now(), #{sourceTable}, #{sourceField}, #{sourceId})")
    void newComment(Comment comment);
    @Select("select * from comment where source_table=#{sourceTable} and source_field=#{sourceField} and source_id=#{sourceId}")
    List<Comment> getAllComments(String sourceTable,String sourceField,Integer sourceId);
    @Delete("delete  from comment where comment_id=#{commentId}")
    void deleteComment(Integer commentId);
}
