package com.niit.sms.service.impl;

import com.niit.sms.bean.Student;
import com.niit.sms.mapper.StudentMapper;
import com.niit.sms.service.StudentrService;
import com.niit.sms.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentrService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(String tno, String password) {
        String mdPassword = MD5Util.MD5Lower(password);
        return studentMapper.login(tno, mdPassword);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public int addStudent(Student student) {
        String lower = MD5Util.MD5Lower(student.getPassword());
        student.setPassword(lower);
        return studentMapper.addStudent(student);
    }

    @Override
    public int delStudentById(Integer id) {
        return studentMapper.delStudentById(id);
    }

    @Override
    public int updateStudentById(Student student) {
        String lower = MD5Util.MD5Lower(student.getPassword());
        student.setPassword(lower);
        return studentMapper.updateStudentById(student);
    }

    @Override
    public Student selectById(String id) {
        return studentMapper.selectById(id);
    }

}
