package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Papers;
import com.xiaohua.springbootpingjiao.entity.Paperstarget;
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
    public List<HashMap<String, String>> selectQuestionnaireinName(String papers_name, int pages, int limit) {
        return QuestionnaireMapper.selectQuestionnaireinName(papers_name,pages,limit);
    }

    @Override
    public List<HashMap<String, String>> selectQuestionnaireinNameCount(String papers_name) {
        return QuestionnaireMapper.selectQuestionnaireinNameCount(papers_name);
    }

    @Override
    public List<HashMap<String, String>> selectQuestionnaireinBatch(String batch_id, int pages, int limit) {
        return QuestionnaireMapper.selectQuestionnaireinBatch(batch_id,pages,limit);
    }

    @Override
    public List<HashMap<String, String>> selectQuestionnaireinBatchCount(String batch_id) {
        return QuestionnaireMapper.selectQuestionnaireinBatchCount(batch_id);
    }

    @Override
    public List<HashMap<String, String>> selectQuestionnaireinRoleid(String role_id, int pages, int limit) {
        return QuestionnaireMapper.selectQuestionnaireinRoleid(role_id,pages,limit);
    }

    @Override
    public List<HashMap<String, String>> selectQuestionnaireinRoleidCount(String role_id) {
        return QuestionnaireMapper.selectQuestionnaireinRoleidCount(role_id);
    }

    @Override
    public List<HashMap<String, String>> selectQuestionnaireinBRCount(String role_id, String batch_id) {
        return QuestionnaireMapper.selectQuestionnaireinBRCount(role_id,batch_id);
    }

    @Override
    public List<HashMap<String, String>> selectQuestionnaireinBR(String role_id, String batch_id, int pages, int limit) {
        return QuestionnaireMapper.selectQuestionnaireinBR(role_id,batch_id,pages,limit);
    }

    @Override
    public boolean insertTarget(Paperstarget c) {
        int result = QuestionnaireMapper.insertTarget(c);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean insertPapers(Papers c) {
        int result = QuestionnaireMapper.insertPapers(c);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<HashMap<String, String>> selectOptions(String target_Id) {
        return QuestionnaireMapper.selectOptions(target_Id);
    }

    @Override
    public List<HashMap<String, String>> selectTargetzhi(String parent_Id) {
        return QuestionnaireMapper.selectTargetzhi(parent_Id);
    }

    @Override
    public List<HashMap<String, String>> selectTarget(String parent_Id) {
        return QuestionnaireMapper.selectTarget(parent_Id);
    }

    @Override
    public boolean deletePapers(Papers c) {
        int result = QuestionnaireMapper.deletePapers(c);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<HashMap<String, String>> selectuser() {
        return QuestionnaireMapper.selectuser();
    }

    @Override
    public List<HashMap<String, String>> selectbatch() {
        return QuestionnaireMapper.selectbatch();
    }

    @Override
    public List<HashMap<String, String>> selectQuestionnaireCount() {
        return QuestionnaireMapper.selectQuestionnaireCount();
    }

    @Override
    public List<HashMap<String,String>> selectQuestionnaire(int pages, int limit) {
        return QuestionnaireMapper.selectQuestionnaire(pages,limit);
    }
}
