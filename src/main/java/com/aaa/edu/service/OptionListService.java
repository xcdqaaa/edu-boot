package com.aaa.edu.service;

import com.aaa.edu.pojo.Cascader;
import com.aaa.edu.pojo.beans.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OptionListService {
    List<OPeriod> getPeriods();

    List<OCollege> getColleges();

    List<OMajor> getMajors();

    List<OMajor> getMajorsByCollegeId(String gId);

    List<OClass> getClasses();

    List<OClass> getClassesByMajorId(String mId);

    List<Cascader> getClassCascader();

    List<OTeacher> getTeachersByCollege(String gId);
}
