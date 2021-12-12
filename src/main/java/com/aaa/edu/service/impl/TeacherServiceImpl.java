package com.aaa.edu.service.impl;

import com.aaa.edu.mapper.TeacherMapper;
import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.view.VTeacher;
import com.aaa.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public IPage<VTeacher> getAllTeachers(QueryInfo info,String college) {
        IPage<VTeacher> iPage = new Page<>();
        iPage.setCurrent(info.getPageNumber());
        iPage.setSize(info.getPageSize());
        QueryWrapper<VTeacher> wrapper = new QueryWrapper<>();
        wrapper.like("t_name",info.getQuery());
        if(college!=null){
            wrapper.like("g_id",college);
        }

        return teacherMapper.selectPage(iPage, wrapper);


    }

   /* @Override
    public RespBean getAllTeachers(QueryInfo info) {
        IPage<Teacher> iPage = new Page<>();
        iPage.setCurrent(info.getPageNumber());
        iPage.setSize(info.getPageSize());
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.like("t_name",info.getQuery());

        IPage<Teacher> page = teacherMapper.selectPage(iPage, wrapper);

        if(page!=null){
            return RespBean.success(null,page);
        }
        return RespBean.error("列表查询失败");
    }*/
}
