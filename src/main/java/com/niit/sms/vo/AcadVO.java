package com.niit.sms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcadVO {

    private Integer id;
    private String acad_name;
    private String teacher_name;
    private Integer teacher_id;

}
