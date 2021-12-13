package com.aaa.edu.controller;

import com.aaa.edu.pojo.RespBean;
import com.aaa.edu.service.OptionListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionListController {
    @Autowired
    OptionListService optionListService;

    @ApiOperation("学院列表")
    @GetMapping("/option/colleges")
    public RespBean getColleges(){
        return RespBean.success(null,optionListService.getColleges());
    }

    @GetMapping("/option/classes")
    public RespBean getClasses(){
        return RespBean.success(null,optionListService.getClassCascader());
    }

    @GetMapping("/option/terms")
    public RespBean getTerms(){
        return RespBean.success(null,optionListService.getPeriods());
    }
    @GetMapping("/option/teachers/{gId}")
    public RespBean getTeachers(@PathVariable String gId){
        return RespBean.success(null,optionListService.getTeachersByCollege(gId));
    }
}
