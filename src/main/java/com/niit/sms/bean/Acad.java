package com.niit.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acad {

    //学院信息
    private Integer id;
    private String acad_name;
    //学院主任信息
    private String manager_id;

}