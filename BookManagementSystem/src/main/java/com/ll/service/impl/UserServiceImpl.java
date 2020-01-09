package com.ll.service.impl;

import com.ll.dao.UserDao;
import com.ll.domain.User;
import com.ll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public void insertUser(String username, String password) {
        userDao.insertUser(username, password);
    }

    @Override
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

}
