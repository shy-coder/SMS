package com.niit.sms.controller;

import com.niit.sms.bean.Clazz;
import com.niit.sms.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName ClazzController
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/29
 **/
@Controller
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Object finaAll(){
        List<Clazz> clazzList = clazzService.findAll();
        return  clazzList;
    }
}
