package com.example.yuisma.other;

import com.example.yuisma.A;

/**
 * @ClassName A2
 * @Description TODO
 * @Author yuisama
 * @Date 2020/4/30 15:45
 */


public class B1 {
    A1 a;

    public String sayHello(String word) {
        //当前这个类已经拥有类A的功能，可以直接调用其中的方法
        return a.sayHello(word);
    }

    public void setA1(A1 a) {
        this.a = a;
    }
}
