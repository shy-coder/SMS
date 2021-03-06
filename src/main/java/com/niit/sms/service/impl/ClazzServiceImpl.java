package com.niit.sms.service.impl;

import com.niit.sms.bean.Clazz;
import com.niit.sms.mapper.ClazzMapper;
import com.niit.sms.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ClazzServiceImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2021/6/29
 **/
@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper cLazzMapper;
    @Override
    public List<Clazz> findAll() {
        return cLazzMapper.findAll();
    }

    @Override
    public Integer updateClazz(Clazz clazz) {
        return cLazzMapper.updateClazz(clazz);
    }

    @Override
    public Integer insertClazz(Clazz clazz) {
        return cLazzMapper.insertClazz(clazz);
    }

    @Override
    public Integer deleteClazz(Integer id) {
        return cLazzMapper.deleteClazz(id);
    }
}
