package com.example.yuisma.JavaBeanDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description Service层
 * @Author yuisama
 * @Date 2020/4/30 16:11
 */

@Service
public class UserService {
    //将UserDao注入到这个类中
    @Autowired
    private UserDao userDao;

    public List<User> queryUser(){
        //调用userDao中方法进行查询
        return this.userDao.queryUser();
    }
}
