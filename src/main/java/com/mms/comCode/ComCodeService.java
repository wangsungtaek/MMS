package com.mms.comCode;

import com.mms.reviewer.ReviewerDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("comCodeService")
public class ComCodeService {

    @Resource(name = "comCodeDao")
    private ComCodeDao comCodeDao;

    // 카테고리 조회
    public List<Map<String, Object>> findCategory(Map<String, Object> param) throws Exception{
        return comCodeDao.findCategory(param);
    }

    // 카테고리 등록
    public boolean createCategory(Map<String, Object> param) throws Exception {
        return comCodeDao.createCategory(param);
    }

    // 카테고리 삭제
    public boolean deleteCategory(Map<String, Object> param) throws Exception {
        return comCodeDao.deleteCategory(param);
    }



}
