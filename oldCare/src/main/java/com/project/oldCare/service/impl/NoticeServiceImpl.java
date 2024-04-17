package com.project.oldCare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.oldCare.entity.Notice;
import com.project.oldCare.service.NoticeService;
import com.project.oldCare.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author wangyating
* @description 针对表【notice(公告：)】的数据库操作Service实现
* @createDate 2024-03-28 11:59:37
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

}




