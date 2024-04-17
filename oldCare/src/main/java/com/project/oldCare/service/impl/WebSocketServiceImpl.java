package com.project.oldCare.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.oldCare.config.GetHttpSessionConfigurator;
import com.project.oldCare.entity.Message;
import com.project.oldCare.service.WebSocketService;
import com.project.oldCare.utils.MessageUtils;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ServerEndpoint(value = "/chat",configurator = GetHttpSessionConfigurator.class)
@Component
public class WebSocketServiceImpl implements WebSocketService {
    private HttpSession httpSession;
    private Session session;
     private static final Map<String,WebSocketServiceImpl>onlineUsers=new HashMap<>() ;

    @OnOpen
    public void onOpen(Session session,EndpointConfig config){
        this.session=session;
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;

        //存储登陆的对象
        Object o= httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        SecurityContextImpl authentication =(SecurityContextImpl) o;
        Authentication authen = authentication.getAuthentication();
        String username = authen.getName();

        //存入上线人的信息
     onlineUsers.put(username,this);
     //获取在线列表
     String message= MessageUtils.getMessage(true,null,getNames());
     //广播给所有人
     broadcastAllUsers(message);
    }
    private Set<String>getNames(){
        return onlineUsers.keySet();
    }
    @OnClose
    public  void onClose(Session session){

        Object o= httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        SecurityContextImpl authentication =(SecurityContextImpl) o;
        Authentication authen = authentication.getAuthentication();
        String username = authen.getName();
        onlineUsers.remove(username);
        MessageUtils.getMessage(true,null,getNames());
    }
    @OnMessage
    public  void onMessage(String message,Session session){
        try{
            ObjectMapper mapper=new ObjectMapper();
            Message mess=mapper.readValue(message, Message.class);
            String toName=mess.getToName();
            String data=mess.getMessage();
            Object o= httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
            SecurityContextImpl authentication =(SecurityContextImpl) o;
            Authentication authen = authentication.getAuthentication();
            String username = authen.getName();

            String resultMessage=MessageUtils.getMessage(false,username,data);
            onlineUsers.get(toName).session.getBasicRemote().sendText(resultMessage);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("error");
        error.printStackTrace();
    }
    public void broadcastAllUsers(String message){
      try{
          Set<String>names=onlineUsers.keySet();
          for(String name:names){
              WebSocketServiceImpl webSocketService=onlineUsers.get(name);
              webSocketService.session.getBasicRemote().sendText(message);
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
}

