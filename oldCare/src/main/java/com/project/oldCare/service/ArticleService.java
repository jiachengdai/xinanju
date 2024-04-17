package com.project.oldCare.service;

import com.project.oldCare.entity.Article;
import com.project.oldCare.entity.PageBean;

import java.time.LocalDateTime;

public interface ArticleService {

    void add(Article article);



    PageBean<Article> getAllInfo(Integer page, Integer pageSize, String type, String tag, LocalDateTime expectedTime);

    Article getDetail(Integer articleId);

    void updateArticle(Article article);

    void deleteArticle(Integer articleId);

    Article findArticleById(Integer articleId);
}
