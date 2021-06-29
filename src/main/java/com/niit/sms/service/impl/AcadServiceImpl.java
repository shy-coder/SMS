package com.niit.sms.service.impl;

import com.niit.sms.bean.Acad;
import com.niit.sms.mapper.AcadMapper;
import com.niit.sms.service.AcadService;
import com.niit.sms.vo.AcadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcadServiceImpl implements AcadService {

    @Autowired
    private AcadMapper acadMapper;

    @Override
    public List<AcadVO> selectAll() {
        return acadMapper.selectAll();
    }

    @Override
    public int updateAcadById(Acad acad) {
        return acadMapper.updateAcadById(acad);
    }

    @Override
    public int addAcad(Acad acad) {
        return acadMapper.addAcad(acad);
    }

    @Override
    public int delAcadById(Integer id) {
        return acadMapper.delAcadById(id);
    }
}
