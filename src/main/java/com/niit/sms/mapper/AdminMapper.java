package com.niit.sms.mapper;

import com.niit.sms.bean.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    Admin login(@Param("username") String username, @Param("password") String password);

}
