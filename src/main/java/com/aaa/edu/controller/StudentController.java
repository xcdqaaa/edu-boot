package com.aaa.edu.controller;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.pojo.view.VStudent;
import com.aaa.edu.pojo.view.VTeacher;
import com.aaa.edu.service.StudentService;
import com.aaa.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("student/students")
    public RespBean getStudents(@RequestBody QueryInfo info) {
        IPage<VStudent> page = studentService.getAllStudents(info);
        if(page!=null){
            return RespBean.success(null, page);
        }
        return RespBean.error("列表查询失败");
    }
}
