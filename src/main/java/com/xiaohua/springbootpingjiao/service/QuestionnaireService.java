package com.xiaohua.springbootpingjiao.service;

import java.util.HashMap;
import java.util.List;

public interface QuestionnaireService {
    List<HashMap<String,String>> selectQuestionnaire(int pages, int limit);
    List<HashMap<String,String>>selectQuestionnaireCount();
    List<HashMap<String,String>>selectbatch();
}
