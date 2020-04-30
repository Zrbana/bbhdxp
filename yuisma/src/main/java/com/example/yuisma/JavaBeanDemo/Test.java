package com.example.yuisma.JavaBeanDemo;

import com.example.yuisma.A;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author yuisama
 * @Date 2020/4/30 16:27
 */


public class Test {
    public static void main(String[] args) {

        //通过java配置来实例化容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //在spring容器中获取Bean对象
        UserService userService = context.getBean(UserService.class);
        List<User> list = userService.queryUser();
        for (User user : list) {
            System.out.println(user.getPasswd() + user.getUserName());
        }
        //销毁该容器
        context.destroy();
    }
}
