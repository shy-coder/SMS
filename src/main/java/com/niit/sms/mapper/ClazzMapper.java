package com.niit.sms.mapper;

import com.niit.sms.bean.Clazz;

import java.util.List;

public interface ClazzMapper {
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
