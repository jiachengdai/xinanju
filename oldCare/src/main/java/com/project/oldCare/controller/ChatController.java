package com.project.oldCare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @GetMapping("/onlineChat")

    public String index(){
        return "chat";
    }

}
