package com.project.oldCare.controller;

import com.project.oldCare.utils.Result;
import com.project.oldCare.entity.*;
import com.project.oldCare.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumService forumService;
    @Autowired
    private HitsService hitsService;
    @Autowired
    private PraiseService praiseService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

   private final String sourceTable="forum";
   private final String sourceField="forum_id";
    @PostMapping("/add")
    public Result addForum(@RequestBody @Validated Forum forum){
        forum.setPraise_len(0);
        forumService.addForum(forum);
        return  Result.success();
    }
    @GetMapping("/detail")
    public Result<Forum> getForumDetail(Integer forumId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
//        Map<String,Object> mp= ThreadLocalUtil.get();
//        String username=(String)  mp.get("username");
      User user=  userService.findByUsername(username);
        Hits hits =new Hits();
        hits.setUserId(user.getId());
        hits.setSourceId(forumId);
        hits.setSourceField("forum_id");
        hits.setSourceTable("forum");
        hitsService.newHit(hits);
       Forum forum= forumService.getForumDetail(forumId);

        String sourceTable="forum";
        String sourceField="forum_id";
        Integer sourceId=forumId;
        forum.setPraise_len(praiseService.praise_len(sourceTable,sourceField,sourceId));
        return Result.success(forum);

    }
    @GetMapping("/praise")
    public Result praise(@RequestParam Integer forumId){

        Integer sourceId=forumId    ;
        praiseService.praise(sourceTable,sourceField,sourceId);
        Integer praise_lens=  praiseService.praise_len(sourceTable,sourceField,sourceId);
        Forum forum= forumService.findforumById(forumId);

        forum.setPraise_len(praise_lens);
        forumService.updateForum(forum);

        return Result.success();
    }
    @PostMapping("/comment")
    public Result newComment(@RequestBody @Validated Comment comment){
        comment.setSourceTable(this.sourceTable);
        comment.setSourceField(this.sourceField);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
//        Map<String,Object> map= ThreadLocalUtil.get();
//        String username=(String)map.get("username");
        User user=userService.findByUsername(username);
        comment.setUserId(user.getId());
        comment.setAvatar(user.getAvatar());
        comment.setNickname(user.getNickName());

        commentService.newComment(comment);
        return  Result.success();
    }

    @GetMapping("/getAllComments")
    public Result<PageBean<Comment>> getAllComments(Integer page ,Integer pageSize,Integer forumId){

        PageBean<Comment>pb=commentService.getAllComments(page,pageSize,sourceTable,sourceField,forumId);
        return Result.success(pb);
    }
    @PutMapping("/update")
    public Result updateForum(@RequestBody @Validated Forum forum){
        forumService.updateForum(forum);
        return Result.success();
    }
    @DeleteMapping("/delete")
    public  Result deleteForum(@RequestParam Integer forumId){
        forumService.deleteForum(forumId);
        return Result.success();
    }
    @GetMapping("/all")
    public Result<PageBean<Forum>> getAllForum(Integer page, Integer pageSize, @RequestParam(required = false) String type, @RequestParam (required = false)String tag,@RequestParam (required = false)LocalDateTime expectedTime){
        PageBean<Forum>pb=forumService.getAllForum(page,pageSize,type,tag ,expectedTime);
        return Result.success(pb);}
}
