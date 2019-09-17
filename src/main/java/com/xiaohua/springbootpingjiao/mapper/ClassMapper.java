package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;

@Repository
public interface ClassMapper {
    List<HashMap> selectAllClass();
}
