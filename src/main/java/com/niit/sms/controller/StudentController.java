package com.niit.sms.controller;

import com.niit.sms.bean.Student;
import com.niit.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DARKW
 */
@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentrService;

    @RequestMapping("/list")
    @ResponseBody
    public Object selectAll(Integer role, Integer id) {
        if (role == 0) {
            Map<String, Object> dataMap= new HashMap<>();
            dataMap.put("code",0);
            dataMap.put("data",studentrService.selectAll());
            return dataMap;
        } else{
            System.out.println("老师id：：：：："+id);
            Map<String, Object> dataMap= new HashMap<>();
            dataMap.put("code",0);
            dataMap.put("data",studentrService.selectAllByTeacher(id));
            return dataMap;
        }
    }



    @RequestMapping("/selectById")
    @ResponseBody
    public Object selectById(String id) {
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",studentrService.selectById(id));
        return dataMap;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object addStudent(Student student) {
        System.out.println(student);
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",studentrService.addStudent(student));
        return dataMap;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Object delStudentById(Integer id) {
        System.out.println(id);
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",studentrService.delStudentById(id));
        return dataMap;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object updateStudentById(Student student) {
        System.out.println("=====>修改："+student);
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",studentrService.updateStudentById(student));
        return dataMap;
    }

}
