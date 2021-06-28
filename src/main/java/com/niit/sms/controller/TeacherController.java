package com.niit.sms.controller;
import com.niit.sms.bean.Teacher;
import com.niit.sms.service.TeacherService;
import com.niit.sms.utils.MD5Util;
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

    @RequestMapping("/teaInfo")
    public String teaInfo(){
        return "/teacher/teaInfo";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object updateTeacher( Teacher teacher){
        Integer status = teacherService.updateTeacher(teacher);
        Map<String, Object> result = new HashMap<>();
        result.put("status",status);
        return result;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Object insertTeacher( Teacher teacher){
        Map<String, Object> result = new HashMap<>();
        Teacher teacher1 = teacherService.findByTno(teacher);
        if(teacher1 != null){
            result.put("status",0);
            result.put("msg","工号重复了");
            return  result;
        }else {
            if(teacher.getPassword().isEmpty()){
                teacher.setPassword(MD5Util.MD5Lower("123456"));
            }else {
                teacher.setPassword(MD5Util.MD5Lower(teacher.getPassword()));
            }
            Integer status = teacherService.insertTeacher(teacher);
            result.put("status",status);
            result.put("msg","");
            return result;
        }
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Object selectById(String id) {
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",teacherService.selectById(id));
        return dataMap;
    }

}
