package com.mms.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("projectService")
public class ProjectService {

    @Resource(name = "projectDao")
    private ProjectDao projectDao;

    // 프로젝트 조회
    public List<Map<String, Object>> findAllProject(Map<String, Object> param) throws Exception{
        return projectDao.findAllProject(param);
    }

    // 프로젝트 상세 조회
    public List<Map<String, Object>> findProject(Map<String, Object> param) throws Exception{
        return projectDao.findProject(param);
    }

    // 프로젝트 등록
    public boolean createProject(Map<String, Object> param) throws Exception {
        return projectDao.createProject(param);
    }



}
