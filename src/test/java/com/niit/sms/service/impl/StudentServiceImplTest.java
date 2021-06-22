package com.niit.sms.service.impl;

import com.niit.sms.bean.Student;
import com.niit.sms.service.StudentrService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    @Autowired
    private StudentrService studentService;

    @Test
    void selectAll() {
        List<Student> students = studentService.selectAll();
        System.out.println(students.toString());
    }
}