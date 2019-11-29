package com.bittech.jcf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * ArrayList 是List接口的实现类
 * <p>
 * Author: secondriver
 * Created: 2019/4/7
 */
public class TestArrayList {
    
    public static void code1() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(1, 4);
        List<Integer> list1 = new ArrayList<>();
        list1.add(6);
        list1.add(7);
        list.addAll(list1);
        
        //list.toString()
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.toArray());
//        for (Integer e : list){
//            System.out.println(e);
//        }
//        list.remove(2);
//        System.out.println(list);
//        list.add(-1,99);
        System.out.println(list);
        System.out.println("是否为空：" + list.isEmpty());
        System.out.println("删除元素：" + list.remove(1));
        System.out.println("是否包含9：" + list.contains(9));
        System.out.println("获取下标1的元素：" + list.get(1));
        System.out.println("修改下标3的元素：" + list.set(3, 99));
        System.out.println(list);
        
        System.out.println(Arrays.toString(list.toArray()));
    }
    
    public static void code2() {
        List<Person> personList = new ArrayList<>();

//        Person p1 = new Person();
//        p1.setName("Jack");
//        p1.setAge(22);
//
//        Person p2 = new Person();
//        p2.setName("Tom");
//        p2.setAge(18);
//
//        personList.add(p1);
//        personList.add(p2);
        personList.add(new Person("Jack", 22));
        personList.add(new Person("Tom", 18));
        
        System.out.println("遍历Person List:");
        for (Person p : personList) {
            System.out.println(p);//toString
        }
        System.out.println("判断对象是否存在：");
        System.out.println(personList.contains(new Person("Jack", 22)));
//        Person p3 = new Person();
//        p3.setName("Jack");
//        p3.setAge(22);
//        System.out.println(personList.contains(p3));
    
    }
    
    public static void code3() {
        List<String> vector = new Vector<>();
        vector.add("A");
        vector.add("B");
        vector.remove("c");
        vector.add("D");
        System.out.println(vector);
    }
    
    public static void main(String[] args) {
        
        //面向接口编程
        //ArrayList
        //1. 无参  初始化容量是多少呢？
        //2. 有参数 int  初始化容量用户自定义
        //3. 有参数 Collection
        List<String> list = new LinkedList<>();
        list.add("A");
        ((LinkedList<String>) list).addFirst("B");
        ((LinkedList<String>) list).addLast("C");
        list.add("D");
        //B A C
        // 头插入， 尾插入
        System.out.println(list);
        
    }
    
    
}
