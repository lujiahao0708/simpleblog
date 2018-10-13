package com.lujiahao.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lujiahao
 * @date 2018-07-19 下午4:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogWebApplication.class)
public class BaseTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTestCase.class);

    @Test
    public void test() {
        System.out.println();
    }
}