package com.aaa.edu.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class StudentInfo {
    private Integer uId;
    private String sGender;
    private String sNation;
    private String sPhone;
    private String sIdentity;
    private String sPlace;
    private String sPolitics;
    private String sEnrollment;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date sBirthday;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date sEntrance;
}
