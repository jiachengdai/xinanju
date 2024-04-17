package com.project.oldCare.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class MySessionInformationExpriedStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

        HashMap result = new HashMap();
        result.put("code",-4);//失败
        result.put("message","该账号已从其他设备登录");

        //将对象结果转化成json字符串
        String json= JSON.toJSONString(result);

        //将json数据返回前端

        HttpServletResponse response = event.getResponse();
        response.setContentType("application/jison;charset=UTF-8");
        response.getWriter().println(json);
    }
}
