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
    /*
     * 프로젝트 리스트
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Map<String, Object>> findProject(
            @RequestParam( value = "searchText",required = false) String param
    ) throws Exception {

        System.out.println("param = " + param);
        Map<String, Object> paramMap = new HashMap<>();
        if(param != null) {
            paramMap.put("searchText", param);
        }
        return projectService.findAllProject(paramMap);
    }

    /*
     * 프로젝트 등록
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean createProject(@RequestBody(required = false) String param) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> paramMap = mapper.readValue(param, Map.class);
        return projectService.createProject(paramMap);
    }
}
