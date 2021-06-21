package com.niit.sms.service;

import com.niit.sms.bean.Teacher;

public interface TeacherService {

    Teacher login(String tno, String password);

}
