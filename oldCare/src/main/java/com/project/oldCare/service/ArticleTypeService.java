package com.project.oldCare.service;

import com.project.oldCare.entity.ArticleType;
import com.project.oldCare.entity.PageBean;

public interface ArticleTypeService {
    void addType(ArticleType articleType);

     PageBean<ArticleType> getAllType(Integer page, Integer pageSize);

     void updateType(ArticleType articleType);

     void deleteType(Integer articleTypeId);
 }
