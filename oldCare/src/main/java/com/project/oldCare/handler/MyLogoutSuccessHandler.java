package com.project.oldCare.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HashMap result = new HashMap();
        result.put("code",0);//成功
        result.put("message","注销成功");

        //将对象结果转化成json字符串
        String json= JSON.toJSONString(result);

        //将json数据返回前端
        response.setContentType("application/jison;charset=UTF-8");
        response.getWriter().println(json);
    }
}
