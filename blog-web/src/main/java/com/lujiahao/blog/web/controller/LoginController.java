package com.lujiahao.blog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lujiahao
 * @date 2018-07-18 下午5:33
 */
@RestController
public class LoginController {
    private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public Map<String, Object> login(String userName, String password) {
        Map<String, Object> result = new HashMap<>();
        if ("lifan".equalsIgnoreCase(userName) && "123".equalsIgnoreCase(password)) {
            result.put("code", 0);
            result.put("msg", "success");
            result.put("data", userName.hashCode());
        } else {
            result.put("code", 1);
            result.put("msg", "fail");
            result.put("data", null);
        }
        return result;
    }

}
