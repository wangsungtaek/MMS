package com.mms.comCode;

import com.mms.common.MmsDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("comCodeDao")
public class ComCodeDao extends MmsDao {


    // 카테고리 조회
    public List<Map<String, Object>> findCategory(Map<String, Object> param) throws Exception {
        return super.selectListInfo("comCode.findCategory", param);
    }

    // 카테고리 생성
    public boolean createCategory(Map<String, Object> param) throws Exception {
        int processCount = super.insertInfo("comCode.createCategory", param);
        boolean isSuccess = false;
        if(processCount != 0){
            isSuccess = true;
        }
        return isSuccess;
    }

    // 카테고리 삭제
    public boolean deleteCategory(Map<String, Object> param) throws Exception {
        int processCount = super.insertInfo("comCode.deleteCategory", param);
        boolean isSuccess = false;
        if(processCount != 0){
            isSuccess = true;
        }
        return isSuccess;
    }
}
