package com.project.oldCare.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        HashMap result = new HashMap();
        result.put("code",-1);//失败
        result.put("message","没有权限");

        //将对象结果转化成json字符串
        String json= JSON.toJSONString(result);

        //将json数据返回前端
        response.setContentType("application/jison;charset=UTF-8");
        response.getWriter().println(json);
    }
}
