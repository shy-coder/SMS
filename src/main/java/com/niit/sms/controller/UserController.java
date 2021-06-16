package com.niit.sms.controller;

import com.niit.sms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        String result = adminService.login(username, password).toString();
        if (result==null){
            return "!!!";
        }else {
            return result;
        }
    }

}
