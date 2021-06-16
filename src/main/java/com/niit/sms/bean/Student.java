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
    private String name;
    private char gender = '男';//default
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String introducation;
    private String portrait_path;//存储头像的项目路径
    private String clazz_name;//班级名称

    public Student(String name, String clazz_name) {
        this.name = name;
        this.clazz_name = clazz_name;
    }

}
