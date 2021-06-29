package com.niit.sms.mapper;

import com.niit.sms.bean.Schedule;
import com.niit.sms.vo.ScheduleVo;

import java.util.List;

public interface ScheduleMapper {
    /**
     * 查询所有排课信息
     * @return List<Schedule>
     */
    List<ScheduleVo> findAll();


    /**
     * 根据教师查询排课信息
     * @param teaId
     * @return List<Schedule>
     */
    List<ScheduleVo> findByTeaId(Integer teaId);

    /**
     * 根据班级查询排课信息
     * @param clazzId
     * @return List<Schedule>
     */
    List<ScheduleVo> findByClazzId(Integer clazzId);


    /**
     * 增加排课信息
     * @return Integer
     */
    Integer insertSchedule(Schedule schedule);

    /**
     * 修改排课信息
     * @param schedule
     * @return Integer
     */
    Integer updateSchedule(Schedule schedule);


    /**
     * 删除排课信息
     * @param  scheId
     * @return Integer
     */
    Integer deleteSchedule(Integer scheId);

}
