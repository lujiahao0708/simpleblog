package com.lujiahao.blogapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author lujiahao
 * @date 2018-03-20 下午7:50
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String index(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "index";
    }
}
