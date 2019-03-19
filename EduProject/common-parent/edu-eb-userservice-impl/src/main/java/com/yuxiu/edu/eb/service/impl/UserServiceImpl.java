package com.yuxiu.edu.eb.service.impl;

import com.yuxiu.edu.eb.service.IUserService;
import com.yuxiu.edu.mapper.UserMapper;
import com.yuxiu.edu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void register(String username, String password) {

    }
}
