package DataStructs.Lists;

public class SingleLinkedList {

    private Node head;
    private int size;
    public SingleLinkedList(){
        head  =new Node(0);
        size=0;
    }

    /**
     * 头插
     * @param x
     */
    public void insertHead(int x){
        insertAt(x,0);
    }

    /**
     * 尾插
     * @param data
     */
    public void insert(int data){
        insertAt(data,size);
    }

    /**
     * 任意位置插入
     * @param data
     * @param position
     */
    public void insertAt(int data,int position){
        checkBounds(position,0,size);
        Node cur = head;
        for(int i =0;i<position;i++){
            cur = cur.next;
        }
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        size++;

    }

    /**
     * 插入有序链表
     * @param data
     */
    public void insertSorted(int data){
        Node cur = head;
        while(cur.next!=null && data > cur.next.value){
            cur = cur.next;
        }
        Node newNode = new Node(data);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }


    public void checkBounds(int position,int low,int high){
        if(position > high || position<low){
            throw new IndexOutOfBoundsException(position+"");
        }
    }


    /**
     * 头删
     */
    public void deleteHead(){
        deleteAt(0);
    }

    /**
     * 尾删
     */
    public void delete(){
        deleteAt(size-1);
    }

    /**
     * 任意位置删
     * @param position
     */
    public void deleteAt(int position){
        checkBounds(position,0,size-1);
        Node cur = head;
        for(int i =0;i<position;i++){
            cur = cur.next;
        }
        Node destory = cur.next;

        cur.next = cur.next.next;
        destory = null;
        size--;
    }

    public void clear(){
        if(size ==0){
            return;
        }
        Node prev = head.next;
        Node cur = prev.next;
        while(cur!=null){
            prev = null;
            prev = cur;
            cur = cur.next;
        }
        prev  =null;
        head.next = null;
        size = 0;


    }


    public boolean isEmpty(){
        return size ==0;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if(size == 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Node cur = head.next;
        while(cur !=null){
            builder.append(cur.value).append("->");
            cur = cur.next;
        }
        return builder.replace(builder.length() - 2, builder.length(), "").toString();

    }
    public SingleLinkedList merge(SingleLinkedList listA, SingleLinkedList listB) {
        Node headA = listA.head.next;
        Node headB = listB.head.next;

        int size = listA.size() + listB.size();

        Node head;
        head = new Node();
        Node tail = head;
        while (headA != null && headB != null) {
            if (headA.value <= headB.value) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;
        }
        if (headA == null) {
            tail.next = headB;
        }
        if (headB == null) {
            tail.next = headA;
        }
        return new SingleLinkedList(head, size);
    }



    private Node head;
    static class Node{
        int value;
        Node next;
        Node(){
        }

        Node(int value){
            this(value,null);
        }
        Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }



    public static void main(String args[]) {
        SingleLinkedList myList = new SingleLinkedList();
        assert myList.isEmpty();
        assert myList.toString().equals("");

        myList.insertHead(5);
        myList.insertHead(7);
        myList.insertHead(10);
        assert myList.toString().equals("10->7->5");

        myList.deleteHead();
        assert myList.toString().equals("7->5");

        myList.insertAt(11, 2);
        assert myList.toString().equals("7->5->11");

        myList.deleteAt(1);
        assert myList.toString().equals("7->11");

        myList.clear();
        assert myList.isEmpty();

        /* Test MergeTwoSortedLinkedList */
        SingleLinkedList listA = new SingleLinkedList();
        SingleLinkedList listB = new SingleLinkedList();

        for (int i = 10; i >= 2; i -= 2) {
            listA.insertSorted(i);
            listB.insertSorted(i - 1);
        }
        assert listA.toString().equals("2->4->6->8->10");
        assert listB.toString().equals("1->3->5->7->9");
        assert SingleLinkedList.merge(listA, listB).toString().equals("1->2->3->4->5->6->7->8->9->10");

    }
}

}
