package com.niit.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    //班级信息
    private Integer id;
    private String name;
    private String number;
    private String introducation;
    //班主任信息
    private String coordinator;
    private String telephone;
    private String email;
    //所属年级
    private String grade_name;

    public Clazz(String name, String grade_name) {
        this.name = name;
        this.grade_name = grade_name;
    }


}
