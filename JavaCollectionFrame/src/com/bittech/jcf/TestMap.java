package com.bittech.jcf;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map :  key = value
 * HashMap :
 * 1. key和value是可以为null
 * 2. key不能重复，value可以重复，key=null（只有一个）
 * <p>
 * Author: secondriver
 * Created: 2019/4/7
 */
public class TestMap {
    
    public static void code1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "C");
        map.put(4, "PHP");
        map.put(3, "JavaScript");
        map.put(null, "Perl");
        map.put(5, null);
        map.put(null, "golang");
        map.put(7, "C++");
        System.out.println("Map的数据：" + map);
        System.out.println("Map的数据数量：" + map.size());
        System.out.println("获取key=1的值：" + map.get(1));
        System.out.println("获取key=6的值：" + map.get(6));
        System.out.println("获取所有的key：" + map.keySet());
        System.out.println("获取所有的value：" + map.values());
        System.out.println("判断key=7是否存在：" + map.containsKey(7));
        System.out.println("删除key=7的元素：" + map.remove(7));
        
        System.out.println("Map的遍历：");
        //1. key -> value
        //2. values (无法获取到key)
        //3. entryset [key-value,,,,]
        for (Integer key : map.keySet()) {
            System.out.printf("%d=%s \n", key, map.get(key));
        }
        System.out.println("-------");
        for (String value : map.values()) {
            System.out.printf("%s \n", value);
        }
        System.out.println("-------");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("%d=%s \n", key, value);
        }
        System.out.println("--------");
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = map.get(key);
            System.out.printf("%d=%s \n", key, value);
        }
    }
    
    public static void code2() {
        //Hashtable key!=null value!=null
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "Java");
        hashtable.put(2, "C++");
        hashtable.put(3, null);
        System.out.println(hashtable);
    }
    
    public static void code3() {
        
        //通过Collections的工具方法包装了对象变成同步对象（线程安全）
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

//        map.put(1, "Java");
//        map.put(2, "C++");
//        map.put(3, "C");
//        map.put(4, "PHP");
//        map.put(3, "JavaScript");
        
        System.out.println(map.getClass().getName());
    }
    
    public static void code4() {
        Map<Person, String> map = new HashMap<>();
        map.put(new Person("Jack", 22), "Jack");
        map.put(new Person("Tom", 18), "Tom");
        map.put(new Person("Alice", 20), "Alice");
        map.put(new Person("Alice", 20), "Alice");
        System.out.println(map);
    }
    
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2)*-1;
            }
        });
        map.put(2, "C++");
        map.put(4, "PHP");
        map.put(1, "Java");
        map.put(3, "C");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.printf("%d=%s\n", entry.getKey(), entry.getValue());
        }
    }
    
}
