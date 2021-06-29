package com.niit.sms.service.impl;

import com.niit.sms.service.AcadService;
import com.niit.sms.vo.AcadVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AcadServiceImplTest {

    @Autowired
    private AcadService acadService;

    @Test
    void selectAll() {
        List<AcadVO> acadVOS = acadService.selectAll();
        System.out.println(acadVOS);
    }
}