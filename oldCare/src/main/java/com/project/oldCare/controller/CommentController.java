package com.project.oldCare.controller;

import com.project.oldCare.service.CommentService;
import com.project.oldCare.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
 public class CommentController {
    @Autowired
    private CommentService commentService;
    @DeleteMapping("/deleteComment")
    public Result deleteComment(@RequestParam Integer commentId){
        commentService.deleteComment(commentId);
        return Result.success();
    }
}
