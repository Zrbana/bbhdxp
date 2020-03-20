package com.zn.test;

public interface ILink<E> {//使用泛型避免安全隐患
    void add(E e);
    int size();//获取数据的个数
    boolean isEmpty();//空集合判断
    Object[] toArray();//将集合元素以数组形式返回
    E get(int index);//根据索引取得数据
    void set(int index,E data);//根据指定索引修改数据
    boolean contains(E data);//判断数据是否存在
}
