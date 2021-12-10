package com.aaa.edu.pojo.view;

import com.aaa.edu.pojo.entity.Class;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("v_lesson")
public class VLesson {
    @TableId
    private String lId;
    private String lName;
    private Double lCrs;
    private String lTerm;
    private String lSubject;
    private String lPlace;
    private String lTime;

    @TableField(exist = false)
    private List<Class> lClasses;
}
