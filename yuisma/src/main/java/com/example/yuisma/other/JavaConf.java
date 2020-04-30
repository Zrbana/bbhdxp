package com.example.yuisma.other;

import com.example.yuisma.A;
import com.example.yuisma.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JavaConf
 * @Description TODO
 * @Author yuisama
 * @Date 2020/4/30 15:45
 */

//这个注解表名当前类是一个配置类
@Configuration
public class JavaConf {

    //声明当前方法的返回值是一个Bean，Bean的名称是方法名
    @Bean
    public A1 a(){
        //创建A1的一个实例对象
        return new A1();
    }

    @Bean
    public B1 b(){
        B1 b1 = new B1();
        b1.setA1(a());
        return b1;
    }

}
