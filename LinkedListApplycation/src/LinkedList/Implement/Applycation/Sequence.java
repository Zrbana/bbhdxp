package LinkedList.Implement.Applycation;

public interface Sequence {

    void add(Object data);//添加元素
    boolean remove(int index);//删除元素
    Object get(int index);//得到指定位置的值
    int size();//元素个数
    boolean contains(Object data);//是否包含指定元素
    Object set(int index, Object newData);//修改指定位置的元素值
    void clear();//清空
    Object[] toArray();//将链表转化为数组输出
}
