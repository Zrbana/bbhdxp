package com.ll.service;

import com.ll.domain.User;

public interface UserService {

    public User findByUsernameAndPassword(String username, String password);

    public void insertUser(String username, String password);

    public User findByUsername(String username);
}
