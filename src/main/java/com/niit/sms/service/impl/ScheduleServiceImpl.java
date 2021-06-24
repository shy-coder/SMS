package com.niit.sms.service.impl;

import com.niit.sms.mapper.ScheduleMapper;
import com.niit.sms.service.ScheduleService;
import com.niit.sms.vo.ScheduleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Integer insertSchedule(ScheduleVo scheduleVo) {

        return scheduleMapper.insertSchedule(scheduleVo);
    }

    @Override
    public Integer updateSchedule(ScheduleVo scheduleVo) {
        return scheduleMapper.updateSchedule(scheduleVo);
    }

    @Override
    public Integer deleteSchedule(Integer scheId) {
        return scheduleMapper.deleteSchedule(scheId);
    }
}
