package com.aaa.edu.mapper;

import com.aaa.edu.pojo.beans.OClass;
import com.aaa.edu.pojo.beans.OCollege;
import com.aaa.edu.pojo.beans.OMajor;
import com.aaa.edu.pojo.beans.OPeriod;
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


}
