package com.lujiahao.blog.service;

import com.lujiahao.blog.entity.User;
import com.lujiahao.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lujiahao
 * @date 2018-07-24 下午8:42
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    Map<Long, User> userMap = new HashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public void delUser(Long id) {
        User removeUser = userMap.remove(id);
        System.out.println(removeUser);
    }

    @Override
    public User getUserById(Long id) {
        User one = userRepository.getOne(id);
        return one;
    }

    @Override
    public List<User> listUser() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
