package com.niit.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Course
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Integer id;
    private String cno;
    private String course_name;
}
