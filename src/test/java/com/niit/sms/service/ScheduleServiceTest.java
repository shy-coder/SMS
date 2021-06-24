package com.niit.sms.service;

import com.niit.sms.vo.ScheduleVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ScheduleServiceTest {
    @Autowired
    private ScheduleService scheduleService;


    @Test
    void findAll() {
        List<ScheduleVo> scheduleVoList = new ArrayList<>();
        scheduleVoList = scheduleService.findAll();
        scheduleVoList.forEach(System.out::println);
    }

    @Test
    void findByTeaId() {
        List<ScheduleVo> scheduleVoList = new ArrayList<>();
        Integer teaId = 16;
        scheduleVoList = scheduleService.findByTeaId(teaId);
        scheduleVoList.forEach(System.out::println);
    }

    @Test
    void findByClazzId() {
        List<ScheduleVo> scheduleVoList = new ArrayList<>();
        Integer clazzId = 1;
        scheduleVoList = scheduleService.findByClazzId(clazzId);
        scheduleVoList.forEach(System.out::println);
    }

    @Test
    void insertSchedule() {
    }

    @Test
    void updateSchedule() {
    }

    @Test
    void deleteSchedule() {
    }
}