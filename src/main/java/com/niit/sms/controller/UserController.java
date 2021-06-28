package com.niit.sms.controller;

import com.niit.sms.bean.Admin;
import com.niit.sms.bean.Student;
import com.niit.sms.bean.Teacher;
import com.niit.sms.service.AdminService;
import com.niit.sms.service.StudentrService;
import com.niit.sms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentrService studentrService;

    @RequestMapping("/login")
    public String login(String username, String password, String role, Model model, HttpSession session) {
        if ("0".equals(role)) {
            Admin admin = adminService.login(username, password);
            if (admin==null) {
                model.addAttribute("msg","用户名或密码错误");
                return "login";
            }else {
                session.setAttribute("loginUser",admin);
                session.setAttribute("role",0);
                return "redirect:/main.html";
            }
        }else if ("1".equals(role)) {
            Teacher teacher = teacherService.login(username, password);
            if (teacher==null) {
                model.addAttribute("msg","用户名或密码错误");
                return "login";
            }else {
                session.setAttribute("loginUser",teacher);
                session.setAttribute("role",1);
                return "redirect:/main.html";
            }
        }else {
            Student student = studentrService.login(username, password);
            if (student==null) {
                model.addAttribute("msg","用户名或密码错误");
                return "login";
            }else {
                session.setAttribute("loginUser",student);
                session.setAttribute("role",2);
                return "redirect:/main.html";
            }
        }
    }

}
