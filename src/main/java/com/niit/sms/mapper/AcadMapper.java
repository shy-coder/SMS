package com.niit.sms.mapper;

import com.niit.sms.bean.Acad;
import com.niit.sms.vo.AcadVO;

import java.util.List;

public interface AcadMapper {

    List<AcadVO> selectAll();

    int updateAcadById(Acad acad);

    int addAcad(Acad acad);

    int delAcadById(Integer id);

}
