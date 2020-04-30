package com.example.yuisma.JavaBeanDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author yuisama
 * @Date 2020/4/30 16:23
 */

//这个注解表明这个类是配置类，相当于一个xml文件
@Configuration
@ComponentScan(basePackages = "com.example.yuisma.JavaBeanDemo")
public class SpringConfig {

    //这个注解表明这是一个Bean对象，相当于xml中的<bean>
    @Bean
    public UserDao getUserDao(){
        return new UserDao();
    }
}
