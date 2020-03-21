package com.zn.number;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/21 22:23
 */


public class Factory {
    private Factory(){}
    public static INumberService getInstance(){
        return new NumberServiceImpl();
    }
}
