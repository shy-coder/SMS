package com.niit.sms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {
    private Integer id;
    private String sno;
    private String student_name;
    private String password;
    private char gender;
    private String email;
    private String telephone;
    private String address;
    private String introduce;
    private String portrait_path;//存储头像的项目路径
    private String clazz_id;//班级id
    private String clazz_name;//班级id

}
