package com.aaa.edu.controller;

import com.aaa.edu.pojo.QueryInfo;
import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.pojo.entity.StudentInfo;
import com.aaa.edu.pojo.entity.TeacherInfo;
import com.aaa.edu.pojo.view.VStudent;
import com.aaa.edu.pojo.view.VTeacher;
import com.aaa.edu.service.StudentService;
import com.aaa.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("student/students")
    public RespBean getStudents(@RequestBody QueryInfo info,String cid) {
        System.out.println(cid+"helloooo");
        IPage<VStudent> page = studentService.getAllStudents(info,cid);
        if(page!=null){
            return RespBean.success(null, page);
        }
        return RespBean.error("列表查询失败");
    }
    @GetMapping("student/info/{id}")
    public RespBean getTeacherInfo(@PathVariable Integer id) {
        StudentInfo studentInfo = studentService.getStudentInfo(id);
        if(studentInfo!=null){
            return RespBean.success(null, studentInfo);
        }
        return RespBean.success(null,new TeacherInfo());
    }
}
