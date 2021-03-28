package com.community.service;

import com.community.dao.UserMapper;
import com.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lyn
 * @tip Come on!Do your way best!
 * @create 2021.03.26.21:24
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){

        return userMapper.selectById(id);
    }
}
