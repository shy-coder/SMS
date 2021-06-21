package com.niit.sms.service.impl;

import com.niit.sms.bean.Admin;
import com.niit.sms.bean.Teacher;
import com.niit.sms.mapper.TeacherMapper;
import com.niit.sms.service.TeacherService;
import com.niit.sms.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(String tno, String password) {
        String mdPassword = MD5Util.MD5Lower(password);
        return teacherMapper.login(tno, mdPassword);

    }

}
