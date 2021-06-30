package com.niit.sms.mapper;

import com.niit.sms.bean.Student;
import com.niit.sms.vo.StudentVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentMapper {

    Student login(@Param("sno") String sno, @Param("password") String password);

    List<StudentVO> selectAllByTeacher(@Param("id") Integer id);

    List<StudentVO> selectAll();

    int addStudent(Student student);

    int delStudentById(Integer id);

    int updateStudentById(Student student);

    Student selectById(@Param("id") String id);
}
