package com.niit.sms.service;

import com.niit.sms.bean.Course;

import java.util.List;

public interface CourseService {
    /**
     * 查询所有课程
     * @return List<Course>
     */
    List<Course> findAll();
}
