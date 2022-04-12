package com.mms.sample;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("sampleDao")
public class SampleDao {

    @Autowired
    SqlSession sql;

    public List<Map> findSampleInfo() throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        System.out.println(123);
        return sql.selectList("sample.sample.findSampleInfo", param);
    }
}
