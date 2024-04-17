package com.project.oldCare.controller;

import com.project.oldCare.entity.*;
import com.project.oldCare.service.*;
import com.project.oldCare.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private HitsService hitsService;
    @Autowired
    private PraiseService praiseService;

    private final String sourceTable="article";
  private final String sourceField="article_id";
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }
    @GetMapping

    public Result<PageBean<Article>> getAllInfo(Integer page, Integer pageSize, @RequestParam(required = false) String type, @RequestParam (required = false)String tag,@RequestParam (required = false)LocalDateTime expectedTime){
        PageBean<Article>pb=articleService.getAllInfo(page,pageSize,type,tag ,expectedTime);
         return Result.success(pb);
    }
    @GetMapping("/detail")
    public Result<Article>getDetail(@RequestParam Integer articleId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Hits hits=new Hits();
//        Map<String,Object> map= ThreadLocalUtil.get();
//        String username=(String) map.get("username");
        User user = userService.findByUsername(username);
        hits.setUserId(user.getId());
        hits.setSourceTable("article");
        hits.setSourceField("article_id");
        hits.setSourceId(articleId);
        hitsService.newHit(hits);
      Article article = articleService.getDetail(articleId);


        String sourceTable="article";
        String sourceField="article_id";
        Integer sourceId=articleId;
      article.setPraise_len(praiseService.praise_len(sourceTable,sourceField,sourceId));
      return Result.success(article);
    }

    @GetMapping("/praise")
    public Result praise(@RequestParam Integer articleId){

        Integer sourceId=articleId;
        praiseService.praise(sourceTable,sourceField,sourceId);
        Integer praise_len=  praiseService.praise_len(sourceTable,sourceField,sourceId);
        Article article= articleService.findArticleById(articleId);

        article.setPraise_len(praise_len);
        articleService.updateArticle(article);

        return Result.success();
    }
    @PostMapping("/comment")
    public Result newComment(@RequestBody @Validated Comment comment){
        comment.setSourceTable(this.sourceTable);
        comment.setSourceField(this.sourceField);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
//        Map<String,Object> map= ThreadLocalUtil.get();
//        String username=(String) map.get("username");
        User user=userService.findByUsername(username);
        comment.setUserId(user.getId());
        comment.setAvatar(user.getAvatar());
        comment.setNickname(user.getNickName());

        commentService.newComment(comment);
        return  Result.success();
    }

    @GetMapping("/getAllComments")
    public Result<PageBean<Comment>> getAllComments(Integer page , Integer pageSize, Integer articleId){

        PageBean<Comment>pb=commentService.getAllComments(page,pageSize,sourceTable,sourceField,articleId);
        return Result.success(pb);
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Result updateArticle(@RequestBody Article article){
        if(article.getPraise_len()==null) {
            Integer praise_len=  praiseService.praise_len(sourceTable,sourceField,article.getArticleId());
            article.setPraise_len(praise_len);
        }
        articleService.updateArticle(article);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public  Result deleteArticle(@RequestParam Integer articleId){
        articleService.deleteArticle(articleId);
        return  Result.success();
    }
}
