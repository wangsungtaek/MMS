package com.mms.project;

import com.mms.common.MmsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("projectDao")
public class ProjectDao extends MmsDao {

    /**
     * 프로젝트 리스트 조회
     */
    public List<Map<String, Object>> findAllProject(Map<String, Object> param) throws Exception {
        return  super.selectListInfo("project.findAllProject", param);
    }
}
