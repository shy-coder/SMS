package com.niit.sms.service.impl;

import com.niit.sms.bean.Admin;
import com.niit.sms.mapper.AdminMapper;
import com.niit.sms.service.AdminService;
import com.niit.sms.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String admin_name, String password) {
        String mdPassword = MD5Util.MD5Lower(password);
        return adminMapper.login(admin_name, mdPassword);
    }


    @Override
    public Admin selectAdminById(String id) {
        return adminMapper.selectAdminById(id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }
}
