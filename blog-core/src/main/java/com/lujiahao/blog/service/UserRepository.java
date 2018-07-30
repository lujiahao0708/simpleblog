package com.lujiahao.blog.service;

import com.lujiahao.blog.entity.User;

import java.util.List;

/**
 * @author lujiahao
 * @date 2018-07-24 下午8:40
 */
public interface UserRepository {

    User saveOrUpdateUser(User user);

    void delUser(Long id);

    User getUserById(Long id);

    List<User> listUser();
}
