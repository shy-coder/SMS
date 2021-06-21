package com.niit.sms.controller;

import com.niit.sms.bean.Teacher;
import com.niit.sms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherController
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/21
 **/
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    
    @RequestMapping("/teacherListData")
    @ResponseBody
    public Object teacherListData(){
        List<Teacher> teachers = teacherService.findAll();
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",teachers);
        return dataMap;
    }
}
