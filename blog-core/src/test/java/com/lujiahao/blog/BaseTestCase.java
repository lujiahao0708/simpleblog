package com.lujiahao.blog;

import com.lujiahao.blog.entity.User;
import com.lujiahao.blog.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lujiahao
 * @date 2018-07-19 下午4:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BaseTestCase {

    @Autowired
    private IUserService userService;

    @Test
    public void test() {
        User userById = userService.getUserById(1l);
        Assert.assertEquals("lujiahao", userById.getName());
    }

}