package com.project.oldCare.service.impl;

import com.project.oldCare.entity.Hits;
import com.project.oldCare.mapper.HitsMapper;
import com.project.oldCare.service.HitsService;
import com.project.oldCare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class HitsServiceImpl implements HitsService {
    @Autowired
   private HitsMapper hitsMapper;
    @Autowired
    private UserService userService;
   //暂时用管理员用户替代老人用户浏览
    @Override
    public void newHit(Hits hits) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
//        Map<String,Object>map= ThreadLocalUtil.get();
//        String username=(String)map.get("username");

        hits.setUserId(userService.findByUsername(username).getId());
         hitsMapper.newHit(hits);
    }
}
