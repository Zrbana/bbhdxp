package com.bittech.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set : 集合元素不能重复
 * HashSet: 不能排序
 * TreeSet: 可以排序
 * 1. 元素类型实现Comparable接口
 * 2. TreeSet构造方法提供Comparator的对象
 * <p>
 * Author: secondriver
 * Created: 2019/4/7
 */
public class TestSet {
    
    public static void code1(){
        Set<Person> personSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName()) * -1;
            }
        });//new HashSet<>();
        personSet.add(new Person("Jack", 22));
        personSet.add(new Person("Tom", 18));
        personSet.add(new Person("Jack", 22));
        personSet.add(new Person("Alice", 16));
    
        System.out.println("集合元素个数：" + personSet.size());
        System.out.println("集合是否包含Person：" + personSet.contains(new Person("Jack", 22)));
        System.out.println(personSet);
    }
    
    public static void main(String[] args) {
        
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jack",22));
        personList.add(new Person("Alice",18));
        personList.add(new Person("Tom",20));
    
        System.out.println(personList);
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge()) * -1;
            }
        });
        System.out.println(personList);
    }
}
