package com.mms.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    @Autowired
    private SampleMapper smapleMapper;

    @RequestMapping(value = "/findSampleInfo.do", method = RequestMethod.GET)
    public List<Map> findSampleInfo() throws Exception {

        List<Map> all = smapleMapper.findAll();

        return all;
    }
}
