package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    ClassMapper classMapper;


}
