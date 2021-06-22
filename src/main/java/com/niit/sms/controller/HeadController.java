package com.niit.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class HeadController {

    private String path = "/head/";

    @PostMapping(value = "/head/upload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }

        String fileName = file.getOriginalFilename(); // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = path; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = path + fileName;
        System.out.println(fileName);
//        String requestURL = request.getRequestURL().toString();
//        String requestURI = request.getRequestURI();
//        System.out.println("requestURL"+requestURL);
//        System.out.println("requestURI"+requestURI);
        return filename;
    }

}
