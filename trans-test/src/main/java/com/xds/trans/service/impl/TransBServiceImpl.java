package com.xds.trans.service.impl;

import com.xds.trans.repository.SimpleRepository;
import com.xds.trans.mapper.SimpleMapper;
import com.xds.trans.po.Simple;
import com.xds.trans.service.TransBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service("transBService")
public class TransBServiceImpl implements TransBService {

    @Autowired
    private SimpleMapper simpleMapper;

    @Autowired
    private SimpleRepository simpleRepository;

    @Transactional(value = "mbtTmg", rollbackFor = Exception.class)
    public Long mybatisInsert() {
        Simple simple = new Simple("lucyBMybatis", new Timestamp(System.currentTimeMillis()));
        Long id = simpleMapper.insert(simple);
    //    int a = 1 / 0;
        return id;
    }

    @Transactional(value = "jpaTmg", rollbackFor = Exception.class)
    public Long jpaInsert() {
        Simple simple = new Simple("lucyBJpa", new Timestamp(System.currentTimeMillis()));
        Simple result = simpleRepository.save(simple);
//        int a = 1 / 0;
        return result.getId();
    }
}
