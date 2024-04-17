package com.project.oldCare.handler;

import com.alibaba.fastjson2.JSON;
import com.project.oldCare.utils.JwtUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;


@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
         JwtUtils jwtUtils = new JwtUtils();
        //RedisUtils redisUtil = new RedisUtils();
//        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        Object principal = authentication.getPrincipal();//获取用户身份信息
//        Object credentials = authentication.getCredentials();//获取用户凭证信息
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();//getAuthorities获取用户权限信息

        //通过了，使用用户名生成jwt，jwt存入返回体返回
        String jwt = jwtUtils.generateToken(authentication.getName());
        response.setHeader(jwtUtils.getHeader(), jwt);
        //然后使用用户名为key，用户信息为value存入redis
        //redisUtil.set("login: "+authentication.getName(),principal);
//
//        Map<String,Object> claims= new HashMap<>();
////        claims.put("id");
////        claims.put("password");
//        claims.put("username",authentication.getName());
//       ThreadLocalUtil.set(claims);
//
        HashMap result = new HashMap();
        result.put("code",0);
        result.put("message","登录成功");
        result.put("data",principal);

        //将对象结果转化成json字符串
        String json= JSON.toJSONString(result);

        //将json数据返回前端
        response.setContentType("application/jison;charset=UTF-8");
        response.getWriter().println(json);
    }
}
