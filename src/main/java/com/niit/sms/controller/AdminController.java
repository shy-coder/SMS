package com.niit.sms.controller;

import com.niit.sms.bean.Admin;
import com.niit.sms.service.AdminService;
import com.niit.sms.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/update")
    @ResponseBody
    public Object updateStudentById(Admin admin) {
        if(!admin.getPassword().isEmpty()){
            admin.setPassword(MD5Util.MD5Lower(admin.getPassword()));
        }
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",adminService.updateAdmin(admin));
        return dataMap;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Object selectById(String id) {
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",adminService.selectAdminById(id));
        return dataMap;
    }

}
