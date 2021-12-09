package com.aaa.edu.pojo.view;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("v_lesson")
public class VLesson {
    private String lId;
    private String cName;
    private Date lDate;
    private String lPlace;
    private String lTime;
}
