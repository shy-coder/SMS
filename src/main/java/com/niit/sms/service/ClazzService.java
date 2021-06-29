package com.niit.sms.service;

import com.niit.sms.bean.Clazz;

import java.util.List;

/**
 * @ClassName ClazzService
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/29
 **/
public interface ClazzService {
    /**
     * 查询所有班级
     * @return List<Clazz>
     */
    List<Clazz> findAll();
}
