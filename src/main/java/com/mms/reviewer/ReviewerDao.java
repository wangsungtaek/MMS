package com.mms.reviewer;

import com.mms.common.MmsDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("reviewerDao")
public class ReviewerDao extends MmsDao {


    // 블로거 조회
    public List<Map<String, Object>> findBloger(Map<String, Object> param) throws Exception {
        return super.selectListInfo("reviewer.findBloger", param);
    }
    // 블로거 생성
    public boolean createBloger(Map<String, Object> param) throws Exception {
        int processCount = super.insertInfo("reviewer.createBloger", param);
        boolean isSuccess = false;
        if(processCount != 0){
            isSuccess = true;
        }
        return isSuccess;
    }
    // 블로거 수정
    public boolean updateBloger(Map<String, Object> param) throws Exception {
        int processCount = super.insertInfo("reviewer.updateBloger", param);
        boolean isSuccess = false;
        if(processCount != 0){
            isSuccess = true;
        }
        return isSuccess;
    }

    // 블로거 삭제
    public boolean deleteBloger(Map<String, Object> param) throws Exception {
        int processCount = super.insertInfo("reviewer.deleteBloger", param);
        boolean isSuccess = false;
        if(processCount != 0){
            isSuccess = true;
        }
        return isSuccess;
    }
}
