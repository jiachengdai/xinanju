package com.project.oldCare.service;

import com.project.oldCare.entity.Comment;
import com.project.oldCare.entity.PageBean;

public interface CommentService {

    void newComment(Comment comment);

    PageBean<Comment> getAllComments(Integer page, Integer pageSize, String sourceTable, String sourceField, Integer sourceId);

    void deleteComment(Integer commentId);
}
