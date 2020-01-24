package DataStructs.HashMap;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;

    }
    public void insert(int data){
        Node temp = head;
        Node newNode  =new Node(data);
        size++;
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    public void delete(int data){

        if(size == 0){
            System.out.println("UnderFlow!");
            return ;

        }else{
            Node cur = head;
            if(cur.data == data){
                head = cur.next;
                size--;
                return;
            }else{
                while(cur.next.next != null){
                    if(cur.next.data == data){
                        cur.next = cur.next.next;
                        return;
                    }
                }
                System.out.println("Key not found");
            }
        }
    }

    public static void display(){
        Node temp = head;
        while(temp != null) {
            System.out.printf("%d ",temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

}









