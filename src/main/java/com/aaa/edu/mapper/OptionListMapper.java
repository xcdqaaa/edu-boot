package com.aaa.edu.mapper;

import com.aaa.edu.pojo.beans.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OptionListMapper {

    @Select("select * from t_period")
    List<OPeriod> getPeriods();

    @Select("select * from t_college")
    List<OCollege> getColleges();

    @Select("select * from t_major")
    List<OMajor> getMajors();

    @Select("select * from t_major where g_id = #{gId}")
    List<OMajor> getMajorsByCollegeId(String gId);

    @Select("select * from t_class")
    List<OClass> getClasses();

    @Select("select * from t_class where m_id = #{mId}")
    List<OClass> getClassesByMajorId(String mId);

    @Select("select * from t_teacher where t_college = #{gId}")
    List<OTeacher> getTeachersByCollege(String gId);


}
