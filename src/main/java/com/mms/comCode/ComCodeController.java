package com.mms.comCode;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ComCodeController {

    @Resource(name = "comCodeService")
    ComCodeService comCodeService;

    // 카테고리 조회
    @PostMapping(value = "/findCategory")
    public List<Map<String, Object>> findCategory(@RequestBody(required = false) Map<String, Object> param) throws Exception {
        List<Map<String, Object>> category = comCodeService.findCategory(param);
        System.out.println("category = " + category);
        return category;
    }

    // 카테고리 등록
    @PostMapping("/category")
    public boolean createCategory(@RequestBody Map<String, Object> param) throws Exception {
        return comCodeService.createCategory(param);
    }

    // 카테고리 삭제
    @PostMapping("/deleteCategory")
    public boolean deleteCategory(@RequestBody Map<String, Object> param) throws Exception {
        return comCodeService.deleteCategory(param);
    }
}
