package com.niit.sms.mapper;

import com.niit.sms.bean.Course;
import java.util.List;

public interface CourseMapper {
    /**
     * 查询所有课程
     * @return List<Course>
     */
    List<Course> findAll();

    /**
     * 添加课程
     * @param course
     * @return Integer
     */
    Integer insertCourse(Course course);

    /**
     * 修改课程
     * @param course
     * @return Integer
     */
    Integer updateCourse(Course course);

    /**
     * 删除课程
     * @param id
     * @return Integer
     */
    Integer deleteCourse(Integer id);

}
