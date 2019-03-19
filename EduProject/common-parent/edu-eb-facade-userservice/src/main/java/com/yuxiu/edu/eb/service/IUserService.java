package com.yuxiu.edu.eb.service;

import com.yuxiu.edu.model.User;

public interface IUserService {

    public User findById(Integer id);
    public void register(String username,String password);
}
