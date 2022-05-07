package com.mms.reviewer;

import com.mms.project.ProjectDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("reviewerService")
public class ReviewerService {

    @Resource(name = "reviewerDao")
    private ReviewerDao reviewerDao;

    // 블로거 조회
    public List<Map<String, Object>> findBloger(Map<String, Object> param) throws Exception{
        return reviewerDao.findBloger(param);
    }

    // 프로젝트 등록
    public boolean createBloger(Map<String, Object> param) throws Exception {
        param.put("division", "blog");
        param.put("signupPath", "system");
        return reviewerDao.createBloger(param);
    }

    // 프로젝트 수정
    public boolean updateBloger(Map<String, Object> param) throws Exception {
        return reviewerDao.updateBloger(param);
    }

    // 프로젝트 삭제
    public boolean deleteBloger(Map<String, Object> param) throws Exception {
        return reviewerDao.deleteBloger(param);
    }



}
