package com.project.oldCare.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.oldCare.entity.Comment;
import com.project.oldCare.entity.PageBean;
import com.project.oldCare.mapper.CommentMapper;
import com.project.oldCare.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
   private CommentMapper commentMapper;
    @Override
    public void newComment(Comment comment) {

        commentMapper.newComment(comment);
    }

    @Override
    public PageBean<Comment> getAllComments(Integer page, Integer pageSize, String sourceTable, String sourceField, Integer sourceId) {
         PageBean<Comment>pb=new PageBean<>();
         PageHelper.startPage(page,pageSize);
         List<Comment>commentList=commentMapper.getAllComments(sourceTable,sourceField,sourceId);
         Page<Comment>p=(Page<Comment>)commentList;
         pb.setTotal(p.getTotal());
         pb.setItems(p.getResult());
         return pb;

    }

    @Override
    public void deleteComment(Integer commentId) {
        commentMapper.deleteComment(commentId);
    }

}
