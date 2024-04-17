package com.project.oldCare.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.oldCare.entity.Article;
import com.project.oldCare.entity.PageBean;
import com.project.oldCare.mapper.ArticleMapper;
import com.project.oldCare.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public void add(Article article) {

       article.setCreateTime(LocalDateTime.now());
       article.setUpdateTime(LocalDateTime.now());
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> getAllInfo(Integer page, Integer pageSize, String type, String tag, LocalDateTime expectedTime) {
         PageBean<Article>pb=new PageBean<>();
         PageHelper.startPage(page,pageSize);
        List<Article>articleList=articleMapper.getAllInfo(type,tag ,expectedTime);
        Page<Article>p=(Page<Article>) articleList;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public Article getDetail(Integer articleId) {
      Article article=      articleMapper.getDetail(articleId);
      articleMapper.newHit(articleId);
      return  article;
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    @Override
    public void deleteArticle(Integer articleId) {
        articleMapper.deleteArticle(articleId);
    }

    @Override
    public Article findArticleById(Integer articleId) {
        return articleMapper.findArticleById(articleId);
    }


}
