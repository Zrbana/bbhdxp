package data.struct.apply;

public class DoubleLinkedList implements Box{
    /**
     * 双向链表的实现
     */
    private int size;
    private Node head;
    private Node tail;

    private class Node{
        Node prev;
        Node next;
        Object data;
        public Node(Object data){
            this.data=data;
        }
        public Node(Node prev,Object data,Node next){
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 尾插法
     * @param data
     */
    @Override
    public void add(Object data) {
        //头结点为空，则新插入的节点是头结点
        Node newNode  =new Node(tail,data,null);
        if(head.next==null) {
            newNode = head;
        }else{
            tail.next = newNode;

        }
        tail = newNode;
        size++;
    }

    @Override
    public boolean remove(int index) {
        rangeCheck(index);
        // 要删除的节点
        Node cur = thisNode(index);
        Node prev = cur.prev;
        Node next = cur.next;
        // 要删除的是头结点
        if (prev == null) {
            head = cur.next;
        }
        // 存在前驱节点
        else {
            prev.next = cur.next;
            cur.prev = null;
        }
        // 要删的是尾节点
        if (next == null) {
            tail = cur.prev;
        }else {
            next.prev = cur.prev;
            cur.prev = null;
        }
        size--;
        return false;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);

        return thisNode(index).data;//返回当前节点的数据域
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object data) {
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        // 取得指定位置Node
        Node node = thisNode(index);
        Object oldData = node.data;
        node.data = newData;
        return oldData;
    }

    @Override
    public void clear() {
        for (Node temp = head;temp!=null;) {
            Node next = temp.next;
            temp.prev = temp.next = null;
            temp.data = null;
            temp = next;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        int i = 0;
        for (Node temp = head;temp != null;temp = temp.next) {
            data[i++] = temp.data;
        }
        return data;
    }

    //范围检查
    public  void rangeCheck(int index){
        if(index<0 ||index>=size){
            throw new IndexOutOfBoundsException("Illegal index");
        }
    }

    //找到当前节点
    public Node thisNode(int index){

        Node temp  = head;

        //如果当前节点在链表的前半部分用head指针
        if(index<(size>>2)){
            for(int i = 0;i<index;i++) {
                temp = temp.next;
            }
            return temp;
        }else{
            for(int i = size-1;i>index;i--){
                temp = temp.prev;
            }
            return temp;
        }
    }

}
