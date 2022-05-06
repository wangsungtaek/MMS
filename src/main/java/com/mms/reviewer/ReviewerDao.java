package com.mms.reviewer;

import com.mms.common.MmsDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("reviewerDao")
public class ReviewerDao extends MmsDao {

    // 블로거 생성
    public boolean createBloger(Map<String, Object> param) throws Exception {
        int processCount = super.insertInfo("reviewer.createBloger", param);
        boolean isSuccess = false;
        if(processCount != 0){
            isSuccess = true;
        }
        return isSuccess;
    }
}
