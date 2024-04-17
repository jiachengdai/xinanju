package com.project.oldCare.mapper;

import com.project.oldCare.entity.ServiceNumber;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wangyating
* @description 针对表【service_number(服务工单数及满意度)】的数据库操作Mapper
* @createDate 2024-03-28 11:59:37
* @Entity com.project.oldcare_demo5.entity.ServiceNumber
*/
@Mapper
public interface ServiceNumberMapper extends BaseMapper<ServiceNumber> {

}




