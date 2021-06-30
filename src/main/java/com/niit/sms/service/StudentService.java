package com.niit.sms.service;

import com.niit.sms.bean.Student;
import com.niit.sms.vo.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    Student login(String sno, String password);

    List<StudentVO> selectAllByTeacher(Integer id);

    List<StudentVO> selectAll();

    int addStudent(Student student);

    int delStudentById(Integer id);

    int updateStudentById(Student student);

    Student selectById(@Param("id") String id);

}
