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
    private String clazz_name;
    private String number;
    //班主任信息
    private Integer coordinator_id;
    //所属院系
    private Integer acad_id;


}
