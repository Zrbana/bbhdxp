package com.zn.test;

/**
 * @ClassName LinkedDemo
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/20 22:57
 */


import com.zn.test.ILink;

public class LinkImpl<E> implements ILink<E> {

    private int count;//保存数据的个数

    private Object[] returnData;//返回的数据保存

    private int foot;//操作数组的下标


    private class Node {         //保存节点的数据关系
        private E data ;      //保存数据
        private Node next ;       //保存下一个引用
        public Node(E data) {          //有数据的情况下才有意义
            this.data = data ;
        }
        //第一次调用：this = LinkImpl.root ;
        //第二次调用：this = LinkImpl.root.next ;
        //第三次调用：this = LinkImpl.root.next.next ;
        public void addNode(Node newNode){      //保存新的Node数据
            if (this.next == null) {   //当前节点的下一个节点为null
                this.next = newNode;      //保存当前节点
            }else {
                this.next.addNode(newNode);
            }
        }

        public void toArrayNode(){
            LinkImpl.this.returnData [LinkImpl.this.foot++]=this.data;
            if(this.next!=null){
                this.next.toArrayNode();
            }
        }

        public E getNode(int index){
            if(LinkImpl.this.foot ++ == index) {
                return this.data;
            }else {
                return this.next.getNode(index);
            }
        }

        public void setNode(int index,E data){
            if(LinkImpl.this.foot ++ ==index){
                this.data = data;
            }else{
                this.next.setNode(index,data);
            }
        }

        public boolean containsNode(E data){
            if (this.data.equals(data)) {

                return true;
            }else{
                if(this.next == null){
                    return false;
                }else{
                    return this.next.containsNode(data);
                }
            }
        }
    }
    //------------以下为Link类中定义的成员-----------------
    private Node root ;       //保存根元素

    //------------以下为Link类中定义的方法-----------------
    @Override
    public void add(E e){
        if(e == null){
            return ;
        }
        //数据本身是不具有关联特性的，只有Node类有，要想关联处理就必须将数据包装在Node类中
        Node newNode = new Node(e);    //创建一个新的节点
        if (this.root == null){            //现在没有根节点
            this.root = newNode;       //第一个节点作为根节点
        }else{                          //根节点存在
            this.root.addNode(newNode);       //将新节点保存在合适的位置
        }
        this.count++;
    }



    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count==0;
    }

    @Override
    public Object[] toArray() {
        if(this.isEmpty()){
            return null;

        }
        this.foot = 0;
        this.returnData = new Object[this.count];
        this.root.toArrayNode();
        return this.returnData;
    }

    @Override
    public E get(int index) {
        if(index >= this.count){
            return null;
        }
        this.foot = 0;
        return this.root.getNode(index);
    }

    @Override
    public void set(int index, E data) {
        if(index >= this.count){
            return;
        }
        this.foot = 0;
        this.root.setNode(index,data);
    }

    @Override
    public boolean contains(E data) {
        if(data == null){
            return false;
        }
        return this.root.containsNode(data);
    }
}
public class LinkedDemo{
    public static void main(String args[])  {
        ILink<String> all = new LinkImpl<String>() ;
        all.add("Hello") ;
        all.add("World") ;
        all.add("MLDN") ;
    }
}