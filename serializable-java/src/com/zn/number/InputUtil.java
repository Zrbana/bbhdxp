package com.zn.number;

import java.util.Scanner;

/**
 * @ClassName InputUtil
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/21 21:59
 */


public class InputUtil {
    private InputUtil(){}

    public static int getInt(String prompt){
        int num = 0;
        boolean flag = true;
        while (flag){
            Scanner input = new Scanner(System.in);
            System.out.println(prompt);//打印提示信息
            if(input.hasNext("\\d+")){
                num = Integer.parseInt(input.next("\\d+"));
                flag = false;
            }else {
                System.out.println("输入的内容不是数字！");
            }
        }
        return num;
    }

    public static String getString(String prompt){
        String str = null;
        boolean flag = true;
        while(flag) {
            Scanner input = new Scanner(System.in);
            System.out.println(prompt);
            if(input.hasNext()) {
                str = input.next().trim();
                if(!" ".equals(str)) {   //不是空字符串
                    flag = flag ;   //结束循环
                }else {
                    System.out.println("输入的内容不允许为空！");
                }
            }else {
                System.out.println("输入的内容不允许为空！");
            }
        }
        return str;
    }


}




