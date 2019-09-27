package com.xiaohua.springbootpingjiao.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface QuestionnaireMapper {
    List<HashMap> selectQuestionnaire(int pages, int limit);
}
