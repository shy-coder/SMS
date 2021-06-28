package com.niit.sms.service.impl;

import com.niit.sms.bean.Admin;
import com.niit.sms.bean.Teacher;
import com.niit.sms.mapper.TeacherMapper;
import com.niit.sms.service.TeacherService;
import com.niit.sms.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(String tno, String password) {
        String mdPassword = MD5Util.MD5Lower(password);
        return teacherMapper.login(tno, mdPassword);

    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public Teacher findByTno(Teacher teacher) {
        return teacherMapper.findByTno(teacher);
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        String lower = MD5Util.MD5Lower(teacher.getPassword());
        teacher.setPassword(lower);
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public int updatePassword(Teacher teacher) {
        return teacherMapper.updatePassword(teacher);
    }

    @Override
    public int deleteTeacher(Teacher teacher) {
        return teacherMapper.deleteTeacher(teacher);
    }

    @Override
    public Teacher selectById(String id) {
        return teacherMapper.selectById(id);
    }

}
