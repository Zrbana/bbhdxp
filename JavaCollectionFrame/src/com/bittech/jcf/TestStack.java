package com.bittech.jcf;

import java.util.Stack;

/**
 * Author: secondriver
 * Created: 2019/4/7
 */
public class TestStack {
    
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("C++");
        stack.push("PHP");
        System.out.println("栈中的元素个数：" + stack.size());
        System.out.println("观察栈顶元素：" + stack.peek());
        System.out.println("出栈：" + stack.pop());
        System.out.println("观察栈顶元素：" + stack.peek());
        System.out.println("出栈：" + stack.pop());
        System.out.println("出栈：" + stack.pop());
        //EmptyStackException
//        System.out.println("出栈："+stack.pop());
        if (stack.isEmpty()) {
            System.out.println("栈空了");
        } else {
            System.out.println("出栈：" + stack.pop());
        }
    }
}
