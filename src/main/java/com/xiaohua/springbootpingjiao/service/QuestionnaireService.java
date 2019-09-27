package com.xiaohua.springbootpingjiao.service;

import java.util.HashMap;
import java.util.List;

public interface QuestionnaireService {
    List<HashMap> selectQuestionnaire(int pages, int limit);
}
