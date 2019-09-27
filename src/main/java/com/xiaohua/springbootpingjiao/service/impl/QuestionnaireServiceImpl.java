package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.mapper.QuestionnaireMapper;
import com.xiaohua.springbootpingjiao.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class QuestionnaireServiceImpl  implements QuestionnaireService {
    @Autowired
    public QuestionnaireMapper QuestionnaireMapper;

    @Override
    public List<HashMap> selectQuestionnaire(int pages, int limit) {
        return QuestionnaireMapper.selectQuestionnaire(pages,limit);
    }
}