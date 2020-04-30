package com.example.yuisma;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ConfDemo
 * @Description 这是一个配置类
 * @Author yuisama
 * @Date 2020/4/30 15:00
 */

//声明当前类是一个配置类
@Configuration
//@ComponentScan表示自动扫描这个包路径下所有使用@Service  @Compenent  @Repository @Controller的类，并注册为Bean
@ComponentScan("com.example.yuisma")
public class ConfDemo {
}
