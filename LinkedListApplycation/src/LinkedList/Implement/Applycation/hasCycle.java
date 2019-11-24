package LinkedList.Implement.Applycation;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 */
public class hasCycle {

    /**
     * 方法一：哈希表
     * 遍历整个链表，并将每个结点的引用存入哈希表中
     * 如果当前节点为空节点，证明链表没有环 return false
     * 如果当前结点的引用已经存在，证明链表有环 return ture
     *
     * @param head
     * @return
     */
    public boolean hasCycle_way01(ListNode head){

        Set<ListNode> linkhash = new HashSet<ListNode>();

        while(head.next!=null){
            if(linkhash.contains(head)){
                return true;
            }else{
                linkhash.add(head);
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 方法二：双指针法
     * 设置一个快指针，一个慢指针，
     * 如果没有环，快指针指NULL
     * 如果有环，两个指针会相遇
     *
     * @param head
     * @return
     */
    public boolean hasCycle_way02(ListNode head){
        ListNode low= head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            low=low.next;
            fast = fast.next.next;
            if(fast==low){
                return true;
            }
        }
        return  false;
    }
}
