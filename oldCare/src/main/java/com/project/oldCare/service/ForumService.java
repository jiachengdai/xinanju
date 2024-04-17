package com.project.oldCare.service;
import com.project.oldCare.entity.Forum;
import com.project.oldCare.entity.PageBean;
import com.project.oldCare.entity.Praise;

import java.time.LocalDateTime;

public interface ForumService {
    void addForum(Forum forum);

    Forum getForumDetail(Integer forumId);

    void updateForum(Forum forum);

    void deleteForum(Integer forumId);


    PageBean<Forum> getAllForum(Integer page, Integer pageSize, String type, String tag, LocalDateTime expectedTime);

    void newPraise(Praise praise);

    Forum findforumById(Integer forumId);
}
