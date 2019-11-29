package com.bittech.jcf;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Author: secondriver
 * Created: 2019/4/7
 */
public class TestIterator {
    
    public static void code1() {
        List<String> data = new ArrayList<>();
        data.add("Java");
        data.add("C++");
        data.add("Python");
        data.add("JavaScript");
        data.add("SQL");
        data.add("PHP");
        
        //遍历
//        for (int i = 0; i < data.size(); i++) {
//            String value = data.get(i);
//            System.out.println(value);
//        }
        //foreach
        //ConcurrentModificationException
        //使用foreach是不能修改线程不安全的集合
//        for (String value : data) {
//            //data.remove("C++");
//            System.out.println(value);
//        }
        //迭代器
        Iterator<String> iterator = data.iterator();
        //   [] [] [] [] []
        //               |
        //hasNext next
        //Scanner
        //JDBC RestSet
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
            //Coding 根据条件删除元素
//            iterator.remove();
            if (value.startsWith("Java")) {
                iterator.remove();
            }
        }
        System.out.println("删除之后输出：");
        System.out.println(data);
    }
    
    
    public static void code2() {
        List<String> data = new ArrayList<>();
        data.add("Java");
        data.add("C++");
        data.add("Python");
        data.add("JavaScript");
        data.add("SQL");
        data.add("PHP");
        
        //返回双向迭代器
        ListIterator<String> listIterator = data.listIterator();
        
        //从前往后输出
//        System.out.println("从前往后输出");
//        while (listIterator.hasNext()) {
//            System.out.print(listIterator.next() + ", ");
//        }
//        System.out.println("从后往前输出：");
//        while (listIterator.hasPrevious()) {
//            System.out.print(listIterator.previous() + ", ");
//        }
    }
    
    public static void main(String[] args) {
        Vector<String> data = new Vector<>();
        data.add("Java");
        data.add("C++");
        data.add("Python");
        data.add("JavaScript");
        data.add("SQL");
        data.add("PHP");
        
        //第三方的库，版本比较旧，不支持Iterator
        Enumeration<String> enumeration = data.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        
        
    }
}
