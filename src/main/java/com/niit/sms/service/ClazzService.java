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

    /**
     * 修改学院信息
     * @param clazz
     * @return Integer
     */
    Integer updateClazz(Clazz clazz);

    /**
     * 添加新学院
     * @param clazz
     * @return Integer
     */
    Integer insertClazz(Clazz clazz);

    /**
     * 删除班级
     * @param id
     * @return Integer
     */
    Integer deleteClazz(Integer id);
}
