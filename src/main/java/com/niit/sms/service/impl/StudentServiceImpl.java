package com.niit.sms.service.impl;

import com.niit.sms.bean.Student;
import com.niit.sms.mapper.StudentMapper;
import com.niit.sms.service.StudentService;
import com.niit.sms.utils.MD5Util;
import com.niit.sms.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(String tno, String password) {
        String mdPassword = MD5Util.MD5Lower(password);
        return studentMapper.login(tno, mdPassword);
    }

    @Override
    public List<StudentVO> selectAllByTeacher(Integer id) {
        return studentMapper.selectAllByTeacher(id);
    }

    @Override
    public List<StudentVO> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int delStudentById(Integer id) {
        return studentMapper.delStudentById(id);
    }

    @Override
    public int updateStudentById(Student student) {
        return studentMapper.updateStudentById(student);
    }

    @Override
    public Student selectById(String id) {
        return studentMapper.selectById(id);
    }

}
