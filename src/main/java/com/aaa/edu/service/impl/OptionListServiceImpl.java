package com.aaa.edu.service.impl;

import com.aaa.edu.mapper.OptionListMapper;
import com.aaa.edu.pojo.beans.OClass;
import com.aaa.edu.pojo.beans.OCollege;
import com.aaa.edu.pojo.beans.OMajor;
import com.aaa.edu.pojo.beans.OPeriod;
import com.aaa.edu.service.OptionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
