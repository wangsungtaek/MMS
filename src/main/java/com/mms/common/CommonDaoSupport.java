package com.mms.common;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CommonDaoSupport extends SqlSessionDaoSupport {

    public int insertInfo(String sqlName, Object object) throws Exception {
        // TODO Auto-generated method stub
        return getSqlSession().insert(sqlName, object);
    }
    public int deleteInfo(String sqlName, Object object) throws Exception {
        // TODO Auto-generated method stub
        return getSqlSession().delete( sqlName, object );
    }

    public int updateInfo( String sqlName, Object object) throws Exception {
        // TODO Auto-generated method stub

        return getSqlSession().update(sqlName, object);
    }

    public Map<String, Object> selectInfo(String sqlName, Object object) throws SQLException {
        // TODO Auto-generated method stub

        return (Map<String, Object>) getSqlSession().selectOne(sqlName,  object);
    }
    public List<Map<String, Object>> selectListInfo(String sqlName, Object object) throws SQLException {
        // TODO Auto-generated method stub
        return (List<Map<String, Object>>)(List<?>) getSqlSession().selectList(sqlName, object);
    }

    public Map<String, Object> selectInfo(String sqlName) throws SQLException {
        // TODO Auto-generated method stub

        return (Map<String, Object>) getSqlSession().selectOne(sqlName);
    }
    public List<Map<String, Object>> selectListInfo(String sqlName) throws SQLException {
        // TODO Auto-generated method stub
        return (List<Map<String, Object>>)(List<?>) getSqlSession().selectList(sqlName);
    }
}
