package com.zn.number;

/**
 * @ClassName IOCaseDemo
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/21 22:24
 */


public class IOCaseDemo {
    public static void main(String[] args) {
        INumberService numberService = Factory.getInstance();
        int result [] = numberService.stat(5);
        System.out.println("最大值："+ result[0]+ "、最小值："+ result[1] );
    }
}
