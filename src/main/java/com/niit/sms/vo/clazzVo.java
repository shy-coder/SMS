package com.niit.sms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName clazzVo
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/29
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class clazzVo {
    //班级信息
    private Integer id;
    private String clazz_name;
    private String number;
    //班主任信息
    private Integer coordinator_id;
    private String coordinator_name;
    //所属院系
    private Integer acad_id;
    private String acad_name;
}
