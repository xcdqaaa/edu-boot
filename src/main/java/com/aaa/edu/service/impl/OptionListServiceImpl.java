package com.aaa.edu.service.impl;

import com.aaa.edu.mapper.OptionListMapper;
import com.aaa.edu.pojo.Cascader;
import com.aaa.edu.pojo.beans.*;
import com.aaa.edu.service.OptionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionListServiceImpl implements OptionListService {
    @Autowired
    OptionListMapper optionListMapper;
    @Override
    public List<OPeriod> getPeriods() {
        return optionListMapper.getPeriods();
    }

    @Override
    public List<OCollege> getColleges() {
        return optionListMapper.getColleges();
    }

    @Override
    public List<OMajor> getMajors() {
        return optionListMapper.getMajors();
    }

    @Override
    public List<OMajor> getMajorsByCollegeId(String gId) {
        return optionListMapper.getMajorsByCollegeId(gId);
    }

    @Override
    public List<OClass> getClasses() {
        return optionListMapper.getClasses();
    }

    @Override
    public List<OClass> getClassesByMajorId(String mId) {
        return optionListMapper.getClassesByMajorId(mId);
    }

    @Override
    public List<Cascader> getClassCascader() {
        List<Cascader> cs1 = new ArrayList<>();
        List<OCollege> colleges = getColleges();
        for (OCollege college :
                colleges) {
            Cascader c1 = new Cascader();
            c1.setLabel(college.getGName());
            c1.setValue(college.getGId());
            List<Cascader> cs2 = new ArrayList<>();
            List<OMajor> majors = getMajorsByCollegeId(college.getGId());
            for (OMajor m :
                    majors) {
                Cascader c2 = new Cascader();
                c2.setLabel(m.getMName());
                c2.setValue(m.getMId());
                List<Cascader> cs3 = new ArrayList<>();
                List<OClass> classes = getClassesByMajorId(m.getMId());
                for (OClass c :
                        classes) {
                    Cascader c3 = new Cascader();
                    c3.setLabel(c.getCName());
                    c3.setValue(c.getCId());
                    cs3.add(c3);
                    System.out.println("aaa"+c3);
                }
                c2.setChildren(cs3);
                cs2.add(c2);
                System.out.println("bbb"+c2);
            }
            c1.setChildren(cs2);
            cs1.add(c1);
        }


        return cs1;
    }

    @Override
    public List<OTeacher> getTeachersByCollege(String gId) {
        return optionListMapper.getTeachersByCollege(gId);
    }

    @Override
    public List<OStudent> getStudentByCollege(String cId) {
        return optionListMapper.getStudentsByCollege(cId);
    }

}
