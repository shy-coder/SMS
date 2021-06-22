package com.niit.sms.mapper;

import com.niit.sms.bean.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

    Student login(@Param("sno") String sno, @Param("password") String password);

}
