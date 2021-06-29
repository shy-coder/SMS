package com.niit.sms.controller;

import com.niit.sms.bean.Acad;
import com.niit.sms.service.AcadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/acad")
public class AcadController {

    @Autowired
    private AcadService acadService;

    @RequestMapping("/list")
    @ResponseBody
    public Object selectAll() {
        Map<String, Object> dataMap= new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("data",acadService.selectAll());
        return dataMap;
    }


    @RequestMapping("/update")
    @ResponseBody
    public Object updateAcad(Acad acad){
        System.out.println(acad);
        Integer status = acadService.updateAcadById(acad);
        Map<String, Object> result = new HashMap<>();
        result.put("status",status);
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object addAcad(Acad acad){
        System.out.println(acad);
        Integer status = acadService.addAcad(acad);
        Map<String, Object> result = new HashMap<>();
        result.put("status",status);
        return result;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Object delAcad(Integer id){
        System.out.println(id);
        Integer status = acadService.delAcadById(id);
        Map<String, Object> result = new HashMap<>();
        result.put("status",status);
        return result;
    }

}
