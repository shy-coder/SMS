package com.niit.sms.controller;

import com.niit.sms.bean.Student;
import com.niit.sms.service.StudentrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("stu")
public class StudentController {

    @Autowired
    private StudentrService studentrService;

    @RequestMapping("list")
    @ResponseBody
    public Object selectAll() {
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",studentrService.selectAll());
        return dataMap;
    }

}