package com.niit.sms.service;

import com.niit.sms.bean.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseServiceTest {
    @Autowired
    private CourseService courseService;
    @Test
    void findAll(){
        List<Course> courseList = courseService.findAll();
        System.out.println(courseList);
    }

}