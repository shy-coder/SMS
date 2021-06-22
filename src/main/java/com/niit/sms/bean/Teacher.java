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
    private String teacher_name;
    private String password;
    private char gender;
    private String email;
    private String telephone;
    private String address;
    private String portraitPath;//存储头像的项目路径
}
