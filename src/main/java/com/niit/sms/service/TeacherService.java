package com.niit.sms.service;

import com.niit.sms.bean.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher login(String tno, String password);


    /**
     * 查询所有教师
     * @return List<Teacher>
     */
    List<Teacher> findAll();

    /**
     *根据工号查询教师信息
     * @param teacher
     * @return Teacher
     */
    Teacher  findByTno(Teacher teacher);

    /**
     * 添加教师
     * @param teacher
     * @return int
     */
    int insertTeacher(Teacher teacher);

    /**
     * 根据id修改教师信息
     * @param teacher
     * @return int
     */
    int updateTeacher(Teacher teacher);

    /**
     * 根据id修改教师密码
     * @param teacher
     * @return int
     */
    int updatePassword(Teacher teacher);

    /**
     * 根据id删除教师
     * @param teacher
     * @return int
     */
    int deleteTeacher(Teacher teacher);

    /**
     * 根据id查询教师
     * @param id
     * @return
     */
    Teacher selectById(String id);

}
