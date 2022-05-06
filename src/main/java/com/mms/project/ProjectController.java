package com.mms.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Resource(name = "projectService")
    ProjectService projectService;

    // 프로젝트 리스트
    @GetMapping("")
    public List<Map<String, Object>> findAllProject(
        @RequestParam( value = "searchText", required = false) String searchText
    ) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchText", searchText);
        System.out.println("paramMap = " + paramMap);
        return projectService.findAllProject(paramMap);
    }

    // 프로젝트 상세
    @GetMapping("/{id}")
    public List<Map<String, Object>> getProjectById(
            @PathVariable String id
    ) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("project_id", id);
        return projectService.findProject(paramMap);
    }



    // 프로젝트 등록
    @PostMapping("")
    public boolean createProject(@RequestBody(required = false) String param) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> paramMap = mapper.readValue(param, Map.class);
        return projectService.createProject(paramMap);
    }
}
