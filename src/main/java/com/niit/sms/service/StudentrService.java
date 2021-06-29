package com.niit.sms.service;

import com.niit.sms.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentrService {
    Student login(String sno, String password);

    List<Student> selectAll();

    int addStudent(Student student);

    int delStudentById(Integer id);

    int updateStudentById(Student student);

    Student selectById(@Param("id") String id);

}
