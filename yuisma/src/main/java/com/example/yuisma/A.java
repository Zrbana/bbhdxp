package com.example.yuisma;

import org.springframework.stereotype.Service;

/**
 * @ClassName A
 * @Description 编写功能类的Bean
 * @Author yuisama
 * @Date 2020/4/30 14:50
 */

//使用@Service注解声明当前类是Spring管理的一个Bean
    //也可以使用其他注解@Compoent @Repository  @Controller,根据需要使用
@Service
public class A {
    public String sayHello(String word){
        return "hello world !";
    }

}
