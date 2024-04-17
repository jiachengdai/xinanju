package com.project.oldCare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.oldCare.entity.DrugManagement;
import com.project.oldCare.service.DrugManagementService;
import com.project.oldCare.mapper.DrugManagementMapper;
import org.springframework.stereotype.Service;

/**
* @author wangyating
* @description 针对表【drug_management(药品管理)】的数据库操作Service实现
* @createDate 2024-04-13 12:06:53
*/
@Service
public class DrugManagementServiceImpl extends ServiceImpl<DrugManagementMapper, DrugManagement>
    implements DrugManagementService{

}




