package com.niit.sms.service.impl;

import com.niit.sms.bean.Schedule;
import com.niit.sms.mapper.ScheduleMapper;
import com.niit.sms.service.ScheduleService;
import com.niit.sms.vo.ScheduleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName ScheduleServiceImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/24
 **/
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleVo> findAll() {
        return scheduleMapper.findAll();
    }

    @Override
    public List<ScheduleVo> findByTeaId(Integer teaId) {

        return scheduleMapper.findByTeaId(teaId);
    }

    @Override
    public List<ScheduleVo> findByClazzId(Integer clazzId) {
        return scheduleMapper.findByClazzId(clazzId);
    }

    @Override
    public Integer insertSchedule(Schedule schedule) {

        return scheduleMapper.insertSchedule(schedule);
    }

    @Override
    public Integer updateSchedule(Schedule schedule) {
        return scheduleMapper.updateSchedule(schedule);
    }

    @Override
    public Integer deleteSchedule( Integer scheId) {
        return scheduleMapper.deleteSchedule(scheId);
    }
}
