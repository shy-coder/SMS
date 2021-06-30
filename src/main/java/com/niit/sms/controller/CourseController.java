package com.niit.sms.controller;

import com.niit.sms.bean.Clazz;
import com.niit.sms.bean.Course;
import com.niit.sms.bean.Schedule;
import com.niit.sms.service.CourseService;
import com.niit.sms.service.ScheduleService;
import com.niit.sms.vo.ScheduleVo;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/25
 **/
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/scheListData")
    @ResponseBody
    public Object scheList(@RequestParam("role") Integer role, @RequestParam(value = "tId", required = false) Integer tId, @RequestParam(value = "cId", required = false) Integer cId) {
        System.out.println(cId);
        List<ScheduleVo> scheduleVoList = new ArrayList<>();
        if (role == 0) {
            scheduleVoList = scheduleService.findAll();
        } else if (role == 1) {
            scheduleVoList = scheduleService.findByTeaId(tId);
        } else if(role == 2) {
            scheduleVoList = scheduleService.findByClazzId(cId);
        }
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("code", 0);
        dataMap.put("data", scheduleVoList);
        return dataMap;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAll() {
       List<Course>  courseList = courseService.findAll();
        return courseList;
    }

    @RequestMapping("/addSche")
    @ResponseBody
    public Integer addSche(Schedule schedule){
        Integer ststus;
        ststus = scheduleService.insertSchedule(schedule);
        return ststus;
    }

    @RequestMapping("/updateSche")
    @ResponseBody
    public Integer updateSche(Schedule schedule){
        Integer status = scheduleService.updateSchedule(schedule);
        return status;
    }

    @RequestMapping("/deleteSche")
    @ResponseBody
    public Integer delete(@RequestParam("id") Integer cid){
        System.out.println(cid);
        Integer status ;
        status = scheduleService.deleteSchedule(cid);
        return status;
    }

    @RequestMapping("/insertCourse")
    @ResponseBody
    public Integer insertCourse(Course course){
        Integer status;
        status = courseService.insertCourse(course);
        return status;
    }

    @RequestMapping("/courseListData")
    @ResponseBody
    public Object courseListData(){
        Map<String,Object> resultMap = new HashMap<>();
        List<Course> courList = courseService.findAll();
        resultMap.put("code",0);
        resultMap.put("data",courList);
        return resultMap;
    }

    @RequestMapping("/updateCourse")
    @ResponseBody
    public Integer deleteCourse(Course course){
        Integer status ;
        status = courseService.updateCourse(course);
        return status;
    }

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public Integer deleteCourse(@RequestParam("id") Integer id){
        Integer status ;
        status = courseService.deleteCourse(id);
        return  status;
    }


}


