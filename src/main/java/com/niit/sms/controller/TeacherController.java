package com.niit.sms.controller;

import com.niit.sms.bean.Teacher;
import com.niit.sms.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteTeacher(@RequestParam("id") Integer teaId){
        Map<String, Object> result = new HashMap<>();
            Teacher teacher = new Teacher();
            teacher.setId(teaId);
            Integer status = teacherService.deleteTeacher(teacher);
            result.put("status",status);
            return result;
    }

}
