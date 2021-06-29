package com.niit.sms.mapper;

import com.niit.sms.bean.Clazz;

import java.util.List;

public interface ClazzMapper {
    /**
     * 查询所有班级
     * @return List<Clazz>
     */
    List<Clazz> findAll();
}
