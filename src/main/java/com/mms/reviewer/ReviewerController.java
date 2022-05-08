package com.mms.reviewer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mms.project.ProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReviewerController {

    @Resource(name = "reviewerService")
    ReviewerService reviewerService;

    // 블로거 조회
    @PostMapping("/findBloger")
    public List<Map<String, Object>> findBloger(
            @RequestBody(required = false) Map<String, Object> param
    ) throws Exception {
        return reviewerService.findBloger(param);
    }

    // 블로거 등록
    @PostMapping("/bloger")
    public boolean createBloger(@RequestBody Map<String, Object> param) throws Exception {
        return reviewerService.createBloger(param);
    }

    // 블로거 수정
    @PatchMapping("/bloger")
    public boolean updateBloger(@RequestBody Map<String, Object> param) throws Exception {
        return reviewerService.updateBloger(param);
    }

    // 블로거 삭제
    @PostMapping("/deleteBloger")
    public boolean deleteBloger(@RequestBody Map<String, Object> param) throws Exception {
        return reviewerService.deleteBloger(param);
    }
}
