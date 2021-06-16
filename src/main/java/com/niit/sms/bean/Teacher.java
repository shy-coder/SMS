package com.niit.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Integer id;
    private String tno;
    private String name;
    private char gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String clazz_name;
    private String portrait_path;//存储头像的项目路径

    public Teacher(String name, String clazz_name) {
        this.name = name;
        this.clazz_name = clazz_name;
    }

}
