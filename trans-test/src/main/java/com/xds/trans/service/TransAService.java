package com.xds.trans.service;

import org.springframework.stereotype.Service;

@Service
public interface TransAService {
    Long mybatisCallJpa();

    Long jpaCallMybatis();
}
