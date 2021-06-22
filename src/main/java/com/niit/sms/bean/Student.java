package com.niit.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String sno;
    private String student_name;
    private String password;
    private char gender;
    private String email;
    private String telephone;
    private String address;
    private String introduce;
    private String portraitPath;//存储头像的项目路径
    private String clazzId;//班级名称

}
