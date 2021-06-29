package com.niit.sms.service.impl;

import com.niit.sms.bean.Course;
import com.niit.sms.mapper.CourseMapper;
import com.niit.sms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/28
 **/
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Override
    public Integer insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    @Override
    public Integer updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public Integer deleteCourse(Integer id) {
        return courseMapper.deleteCourse(id);
    }
}
