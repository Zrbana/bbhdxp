package com.bittech.jcf;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: secondriver
 * Created: 2019/4/7
 */
public class TestQueue {
    
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Java");
        queue.add("C++");
        queue.add("PHP");
        System.out.println("队列的元素个数："+queue.size());
        System.out.println("队头："+queue.peek());
        System.out.println("出队列："+queue.poll());
        System.out.println("出队列："+queue.poll());
        System.out.println("出队列："+queue.poll());
        System.out.println("出队列："+queue.poll());
        
    }
}
