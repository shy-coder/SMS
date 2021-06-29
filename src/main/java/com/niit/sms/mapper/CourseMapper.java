package com.niit.sms.mapper;

import com.niit.sms.bean.Course;
import java.util.List;

public interface CourseMapper {
    /**
     * 查询所有课程
     * @return List<Course>
     */
    List<Course> findAll();
}
