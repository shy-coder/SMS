package com.niit.sms.mapper;

import com.niit.sms.bean.Admin;
import com.niit.sms.bean.Teacher;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    Admin login(@Param("admin_name") String admin_name, @Param("password") String password);

    Admin selectAdminById(String id);

    int updateAdmin(Admin admin);

    Admin selectAdminById(String id);

    int updateAdmin(Admin admin);

}
