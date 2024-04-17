package com.project.oldCare.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.oldCare.entity.ArticleType;
import com.project.oldCare.entity.PageBean;
import com.project.oldCare.mapper.ArticleTypeMapper;
import com.project.oldCare.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
 @Autowired
 private ArticleTypeMapper articleTypeMapper;
 @Override
 public void addType(ArticleType articleType) {
  articleTypeMapper.addType(articleType);
 }

 @Override
 public PageBean<ArticleType> getAllType(Integer page, Integer pageSize) {
  PageBean<ArticleType>pb=new PageBean<>();
  PageHelper.startPage(page,pageSize);
  List<ArticleType> articleTypeList=articleTypeMapper.getAllType( );
  Page<ArticleType> p=(Page<ArticleType>) articleTypeList;
  pb.setTotal(p.getTotal());
  pb.setItems(p.getResult());
   return pb;
 }

 @Override
 public void updateType(ArticleType articleType) {
  articleTypeMapper.updateType(articleType);
 }

 @Override
 public void deleteType(Integer articleTypeId) {
  articleTypeMapper.deleteType(articleTypeId);
 }
}
