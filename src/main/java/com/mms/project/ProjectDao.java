package com.mms.project;

import com.mms.common.MmsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("projectDao")
public class ProjectDao extends MmsDao {


     // 프로젝트 리스트 조회
    public List<Map<String, Object>> findAllProject(Map<String, Object> param) throws Exception {
        return super.selectListInfo("project.findAllProject", param);
    }

    // 프로젝트 상세 조회
    public List<Map<String, Object>> findProject(Map<String, Object> param) throws Exception {
        return super.selectListInfo("project.findProject", param);
    }

    // 프로젝트 생성
    public boolean createProject(Map<String, Object> param) throws Exception {
        int processCount = super.insertInfo("project.createProject", param);
        boolean isSuccess = false;
        if(processCount != 0){
            isSuccess = true;
        }
        return isSuccess;
    }
}
