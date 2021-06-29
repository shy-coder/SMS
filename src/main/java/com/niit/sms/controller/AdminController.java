package com.niit.sms.controller;

import com.niit.sms.bean.Admin;
import com.niit.sms.service.AdminService;
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
        System.out.println("=====>修改："+admin);
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
