package com.aaa.edu.mapper;


import com.aaa.edu.pojo.entity.Student;
import com.aaa.edu.pojo.entity.StudentInfo;
import com.aaa.edu.pojo.view.VStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface StudentMapper extends BaseMapper<VStudent> {
    StudentInfo getStudentInfo(Integer uId);
}
