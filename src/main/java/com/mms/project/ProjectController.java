package com.mms.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectMapper projectMapper;

    /*
     * 프로젝트 리스트
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Map> findProject() throws Exception {

        return projectMapper.findAll();
    }
}
