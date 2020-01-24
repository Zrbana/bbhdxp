package DataStructs.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_SortedLinkedList {
    Node mergeList(Node[] a,int N){
        //min heap
        PriorityQueue<Node> min = new
                PriorityQueue<>(Comparator.comparingInt(x -> x.data));
        min.addAll(Arrays.asList(a).subList(0,N));

        //make new head among smallest heads in linkedList
        Node head  = min.poll();
        min.add(head.next);
        Node curr = head;

        //merging linkedlist
        while(!min.isEmpty()){
            Node temp = min.poll();
            curr.next = temp;
            curr = temp;

            if(temp.next!=null){
                min.add(temp.next);
            }
            return head;
        }
    }

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }
}
