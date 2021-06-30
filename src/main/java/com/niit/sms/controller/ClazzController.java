package com.niit.sms.controller;

import com.niit.sms.bean.Clazz;
import com.niit.sms.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/clazzListData")
    @ResponseBody
    public Object ClazzListData(){
        Map<String,Object> resultMap = new HashMap<>();
        List<Clazz> clazzList = clazzService.findAll();
        resultMap.put("code",0);
        resultMap.put("data",clazzList);
        return resultMap;
    }

    @RequestMapping("/updateClazz")
    @ResponseBody
    public Integer updateClazz(Clazz clazz){
        Integer status = clazzService.updateClazz(clazz);
        return status;
    }
    @RequestMapping("/insertClazz")
    @ResponseBody
    public Integer insertClazz(Clazz clazz){
        System.out.println(clazz);
        Integer status  = clazzService.insertClazz(clazz);
            return status;
    }

    @RequestMapping("/deleteClazz")
    @ResponseBody
    public Integer deleteClazz(@RequestParam("id") Integer id){
        Integer status = clazzService.deleteClazz(id);
            return status;
    }
}
