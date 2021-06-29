package com.niit.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;
    private String admin_name;
    private String password;
    private char gender;
    private String email;
    private String telephone;
    private String address;
    private String portrait_path;//存储头像的项目路径

}
