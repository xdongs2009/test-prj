package com.xds.trans;


import com.xds.trans.service.TransAService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/spring.xml"})
public class TransTest {

    @Autowired
    private TransAService transAService;

    @Test
    public void mybatisCallJpaTest() {
        transAService.mybatisCallJpa();
    }


    @Test
    public void jpaCallMybatis() {
        transAService.jpaCallMybatis();
    }
}
