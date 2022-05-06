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

    // 프로젝트 등록
    public boolean createBloger(Map<String, Object> param) throws Exception {
        param.put("division", "blog");
        param.put("signupPath", "system");
        return reviewerDao.createBloger(param);
    }



}
