package com.mms.common;

import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

public abstract class MmsDao extends CommonDaoSupport {

    @Resource(name = "sqlSessionFactory")
    protected void setSuperSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
