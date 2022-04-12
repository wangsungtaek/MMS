package com.mms.sample;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SampleMapper {

    @Select("SELECT * FROM MEMBER")
    List<Map> findAll();
}
