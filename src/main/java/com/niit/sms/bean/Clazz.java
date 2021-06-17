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
    private String className;
    private String number;
    private String introduce;
    //班主任信息
    private String coordinator;
    //所属年级
    private String gradeId;

    public Clazz(String className, String gradeId) {
        this.className = className;
        this.gradeId = gradeId;
    }


}
