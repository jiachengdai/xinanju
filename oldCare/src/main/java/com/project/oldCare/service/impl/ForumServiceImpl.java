package com.project.oldCare.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.oldCare.entity.Forum;
import com.project.oldCare.entity.PageBean;
import com.project.oldCare.entity.Praise;
import com.project.oldCare.mapper.ForumMapper;
import com.project.oldCare.mapper.PraiseMapper;
import com.project.oldCare.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
   private ForumMapper forumMapper;
@Autowired
private PraiseMapper praiseMapper;


    @Override
    public void addForum(Forum forum) {
        forumMapper.addForum(forum);

    }

    @Override
    public Forum getForumDetail(Integer forumId) {
         forumMapper.newHit(forumId);
         Forum forum=  forumMapper.getForumDetail(forumId);
        return forum;
    }

    @Override
    public void updateForum(Forum forum) {

        forumMapper.updateForum(forum);

    }

    @Override
    public void deleteForum(Integer forumId) {
        forumMapper.deleteForum(forumId);

    }

    @Override
    public PageBean<Forum> getAllForum(Integer page, Integer pageSize, String type, String tag, LocalDateTime expectedTime) {
        PageBean<Forum>pb=new PageBean<>();
        PageHelper.startPage(page,pageSize);
        List<Forum>forumList=forumMapper.getAllForum(type,tag ,expectedTime);
        Page<Forum>p=(Page<Forum>) forumList;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void newPraise(Praise praise) {
        praiseMapper.newPraise(praise);
    }

    @Override
    public Forum findforumById(Integer forumId) {
        return forumMapper.findForumById(forumId);
    }

}
