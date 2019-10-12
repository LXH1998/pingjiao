package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Papers;

import java.util.HashMap;
import java.util.List;

public interface QuestionnaireService {
    List<HashMap<String,String>> selectQuestionnaire(int pages, int limit);
    List<HashMap<String,String>>selectQuestionnaireCount();
    List<HashMap<String,String>>selectbatch();
    List<HashMap<String,String>>selectuser();
    List<HashMap<String,String>>selectQuestionnaireinName(String papers_name,int pages, int limit);
    List<HashMap<String,String>>selectQuestionnaireinNameCount(String papers_name);

    List<HashMap<String,String>>selectQuestionnaireinBatch(String batch_id,int pages, int limit);
    List<HashMap<String, String>> selectQuestionnaireinBatchCount(String batch_id);

    List<HashMap<String, String>> selectQuestionnaireinRoleid(String role_id, int pages, int limit);
    List<HashMap<String, String>> selectQuestionnaireinRoleidCount(String role_id);

    List<HashMap<String, String>> selectQuestionnaireinBR(String role_id,String batch_id, int pages, int limit);
    List<HashMap<String, String>> selectQuestionnaireinBRCount(String role_id,String batch_id);

    List<HashMap<String, String>> selectTarget(String parent_Id);
    List<HashMap<String, String>>  selectTargetzhi(String parent_Id);

    boolean deletePapers(Papers c);
}
