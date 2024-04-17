package com.project.oldCare.mapper;

import com.project.oldCare.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wangyating
* @description 针对表【notice(公告：)】的数据库操作Mapper
* @createDate 2024-03-28 11:59:37
* @Entity com.project.oldcare_demo5.entity.Notice
*/
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

}




