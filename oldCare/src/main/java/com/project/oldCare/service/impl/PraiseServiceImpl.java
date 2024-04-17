package com.project.oldCare.service.impl;
import com.project.oldCare.entity.Praise;
import com.project.oldCare.entity.User;
import com.project.oldCare.mapper.PraiseMapper;
import com.project.oldCare.service.PraiseService;
import com.project.oldCare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PraiseServiceImpl implements PraiseService {
    @Autowired
    private PraiseMapper praiseMapper;
    @Autowired
    private UserService userService;

    @Override
    public void praise(String sourceTable, String sourceField, Integer sourceId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
//        Map<String ,Object>mp= ThreadLocalUtil.get();
//        String username=(String)mp.get("username");
        User user =userService.findByUsername(username);
        Long userId=user.getId();
        Praise praise=praiseMapper.findPraiseByIds(userId,sourceTable,sourceField,sourceId);
        if(praise==null){
            Praise Npraise=new Praise();
            Npraise.setUserId(userId);
            Npraise.setSourceTable(sourceTable);
            Npraise.setSourceField(sourceField);
            Npraise.setSourceId(sourceId);
            Npraise.setStatus(1);
            praiseMapper.newPraise(Npraise);
        }
        else{
            if(praise.getStatus()==1){
                praise.setStatus(0);
            }
            else{
                praise.setStatus(1);
            }
        praiseMapper.updatePraise(praise);}
    }

    @Override
    public Integer praise_len(String sourceTable, String sourceField, Integer sourceId) {
      Integer praise_lens=  praiseMapper.praise_len(sourceTable,sourceField,sourceId);
      return praise_lens;
    }

}
