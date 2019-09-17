package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.mapper.ClassMapper;
import com.xiaohua.springbootpingjiao.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    public ClassMapper classMapper;

    @Override
    public List<HashMap> selectAllClass() {
        return classMapper.selectAllClass();
    }
}
