package com.niit.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String sno;
    private String username;
    private String password;
    private char gender = '男';//default
    private String email;
    private String telephone;
    private String address;
    private String introduce;
    private String portraitPath;//存储头像的项目路径
    private String clazzId;//班级名称

    public Student(String username, String clazzId) {
        this.username = username;
        this.clazzId = clazzId;
    }

}
