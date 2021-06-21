package com.niit.sms.mapper;

import com.niit.sms.bean.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    Teacher login(@Param("tno") String tno, @Param("password") String password);

}
