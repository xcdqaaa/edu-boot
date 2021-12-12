package com.aaa.edu.controller;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.pojo.entity.TeacherInfo;
import com.aaa.edu.pojo.view.VTeacher;
import com.aaa.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("teacher/teachers")
    public RespBean getAllTeachers( @RequestBody QueryInfo info,String college) {
        System.out.println(info);
        IPage<VTeacher> page = teacherService.getAllTeachers(info,college);
        if(page!=null){
            return RespBean.success(null, page);
        }
        return RespBean.error("列表查询失败");
    }
    @GetMapping("teacher/info/{id}")
    public RespBean getTeacherInfo(@PathVariable Integer id) {
        TeacherInfo teacherInfo = teacherService.getTeacherInfo(id);
        if(teacherInfo!=null){
            return RespBean.success(null, teacherInfo);
        }
        return RespBean.success(null,new TeacherInfo());
    }
}
