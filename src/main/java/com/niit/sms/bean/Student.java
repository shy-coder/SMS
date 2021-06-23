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
    private char gender;
    private String email;
    private String telephone;
    private String address;
    private String introduce;
    private String portrait_path;//存储头像的项目路径
    private String clazz_id;//班级名称

}
