package com.ll.test;

import com.ll.domain.User;
import com.ll.service.BookService;
import com.ll.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUserDao {

    @Test
    public void run1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService us = (UserService) ioc.getBean("userService");
        User zhangsan = us.findByUsernameAndPassword("zhangsan", "123");
        System.out.println(zhangsan);
    }
}
