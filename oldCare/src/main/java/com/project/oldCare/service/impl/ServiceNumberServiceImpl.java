package com.project.oldCare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.oldCare.entity.ServiceNumber;
import com.project.oldCare.service.ServiceNumberService;
import com.project.oldCare.mapper.ServiceNumberMapper;
import org.springframework.stereotype.Service;

/**
* @author wangyating
* @description 针对表【service_number(服务工单数及满意度)】的数据库操作Service实现
* @createDate 2024-03-28 11:59:37
*/
@Service
public class ServiceNumberServiceImpl extends ServiceImpl<ServiceNumberMapper, ServiceNumber>
    implements ServiceNumberService{

}




