package com.project.oldCare.controller;

import com.project.oldCare.utils.AliOssUtil;
import com.project.oldCare.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileUploadController {
    @PostMapping ("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
      String originalFilename= file.getOriginalFilename();
        String fileName= UUID.randomUUID() +originalFilename.substring(originalFilename.lastIndexOf("."));
//        file.transferTo(new File("D:\\code_learn\\springboot_learn\\pic\\"+fileName));
      String url=  AliOssUtil.uploadFile(fileName,file.getInputStream());
        return Result.success(url);


    }
}
