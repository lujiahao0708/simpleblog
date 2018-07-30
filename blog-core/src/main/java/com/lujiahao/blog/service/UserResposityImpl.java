package com.lujiahao.blog.service;

import com.lujiahao.blog.entity.TradeUser;
import com.lujiahao.blog.entity.User;
import com.lujiahao.blog.mapper.TradeUserMapper;
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
public class UserResposityImpl implements UserRepository {

    @Autowired
    private TradeUserMapper tradeUserMapper;

    Map<Long, User> userMap = new HashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        User user1 = userMap.put(user.getId(), user);
        return user1;
    }

    @Override
    public void delUser(Long id) {
        User removeUser = userMap.remove(id);
        System.out.println(removeUser);
    }

    @Override
    public User getUserById(Long id) {
        TradeUser tradeUser = tradeUserMapper.selectByPrimaryKey(1);
        return userMap.get(id);
    }

    @Override
    public List<User> listUser() {
        List<User> userList = new ArrayList<>();
        for (User user : userMap.values()) {
            userList.add(user);
        }
        return userList;
    }
}
