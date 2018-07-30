package com.lujiahao.blog.controller;

import com.lujiahao.blog.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lujiahao
 * @date 2018-07-24 下午8:51
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView userList(Model model) {
        model.addAttribute("userList", userRepository.listUser());
        model.addAttribute("title", "用户管理");
        ModelAndView modelAndView = new ModelAndView();
        return new ModelAndView("users/list", "userModel", model);
    }
}
