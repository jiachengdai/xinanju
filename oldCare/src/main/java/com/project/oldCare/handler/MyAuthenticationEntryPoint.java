package com.project.oldCare.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
         String localizedMessage = "需要登录";//authException.getLocalizedMessage();

        HashMap result = new HashMap();
        result.put("code",-2);//失败
        result.put("message",localizedMessage);

        //将对象结果转化成json字符串
        String json= JSON.toJSONString(result);

        //将json数据返回前端
        response.setContentType("application/jison;charset=UTF-8");
        response.getWriter().println(json);

    }
}
