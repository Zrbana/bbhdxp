package com.example.yuisma.JavaBeanDemo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description 持久化层
 * @Author yuisama
 * @Date 2020/4/30 16:08
 */

//模拟生成一组数据放在List集合中
@Repository
public class UserDao {
    public List<User> queryUser(){
        List<User> result = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            User user= new User();
            user.setUserName("name "+i);
            user.setPasswd("passwd"+i);
            result.add(user);
        }
        return result;
    }
}
