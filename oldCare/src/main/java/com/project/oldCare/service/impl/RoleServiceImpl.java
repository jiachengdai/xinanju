package com.project.oldCare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.oldCare.entity.Role;
import com.project.oldCare.service.RoleService;
import com.project.oldCare.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author wangyating
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2024-03-28 11:59:37
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




