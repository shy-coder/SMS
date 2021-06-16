package com.niit.sms.service;

import com.niit.sms.bean.Admin;

public interface AdminService {

    Admin login(String username, String password);

}
