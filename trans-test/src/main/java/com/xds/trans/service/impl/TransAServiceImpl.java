package com.xds.trans.service.impl;

import com.xds.trans.repository.SimpleRepository;
import com.xds.trans.mapper.SimpleMapper;
import com.xds.trans.po.Simple;
import com.xds.trans.service.TransAService;
import com.xds.trans.service.TransBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


@Service("transAService")
public class TransAServiceImpl implements TransAService {

    @Autowired
    private TransBService transBService;

    @Autowired
    private SimpleMapper simpleMapper;

    @Autowired
    private SimpleRepository simpleRepository;

    @Transactional(value = "jpaTmg")
    public Long mybatisCallJpa() {
        Simple simple = new Simple("lucyAMybatis", new Timestamp(System.currentTimeMillis()));
        simpleMapper.insert(simple);
        transBService.jpaInsert();
        return 1L;
    }


    @Transactional(value = "jpaTmg")
    public Long jpaCallMybatis() {
        Simple simple = new Simple("lucyAJpa", new Timestamp(System.currentTimeMillis()));
        simpleRepository.save(simple);
        transBService.mybatisInsert();
        return 1L;
    }
}
