package com.aaa.edu.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class TeacherInfo {
    private Integer uId;
    private String tGender;
    private String tNation;
    private String tPhone;
    private String tIdentity;
    private String tPlace;
    private String tPolitics;
    private String tEducation;
    private String tRank;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tBirthday;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tEntrance;
}
