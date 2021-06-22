package com.niit.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

    //年级信息
    private Integer id;
    private String grade_name;
    private String introduce;
    //年级主任信息
    private String manager;

}