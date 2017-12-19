package com.chen.springbootredisdemo;

import com.chen.springbootredisdemo.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisDemoApplicationTests {

    public static Logger logger = LoggerFactory.getLogger(SpringbootRedisDemoApplicationTests.class);

    @Autowired
    private RedisDao redisDao;


    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        redisDao.setKey("name", "chen");
        logger.info(redisDao.getValue("name"));
    }
}
