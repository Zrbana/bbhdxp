package com.example.yuisma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName B
 * @Description 编写一个类B，将类A注入到类B中
 * @Author yuisama
 * @Date 2020/4/30 14:55
 */

//@Service注解声明当前类是Spring管理的一个Bean
@Service
public class B {
    //用@Autowired注解将类A的实体Bean注入到当前类B中
    //让当前这个类具备类A的功能
    @Autowired
    A a;

    public String sayHello(String word){
        //当前这个类已经拥有类A的功能，可以直接调用其中的方法
        return a.sayHello(word);
    }

}
