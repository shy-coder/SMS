package com.niit.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Schedule
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Integer id;
    private Integer course_id;
    private Integer teacher_id;
    private Integer clazz_id;
    private String room;
    private String course_time;
    private String course_week;
}
