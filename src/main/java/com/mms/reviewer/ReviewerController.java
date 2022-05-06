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

    // 리뷰어 등록
    @PostMapping("/bloger")
    public boolean createBloger(@RequestBody Map<String, Object> param) throws Exception {

        return reviewerService.createBloger(param);
    }
}
