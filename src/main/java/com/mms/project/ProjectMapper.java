package com.mms.project;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectMapper {

    @Select("SELECT *\n" +
            "FROM PROJECT\n" +
            "WHERE project_id IN (\n" +
            "  SELECT project_id\n" +
            "  FROM USER_PROJECT\n" +
            "  WHERE USER_ID = 1\n" +
            ")")
    List<Map> findAll();
}
