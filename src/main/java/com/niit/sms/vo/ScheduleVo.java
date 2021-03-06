package com.niit.sms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ScheduleVo
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/24
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleVo {
    private Integer id;
    private Integer course_id;
    private String course_name;
    private Integer teacher_id;
    private String teacher_name;
    private Integer clazz_id;
    private String clazz_name;
    private String room;
    private String course_time;
    private String course_week;
}
