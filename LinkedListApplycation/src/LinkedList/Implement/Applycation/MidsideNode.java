package LinkedList.Implement.Applycation;



/**
 * 返回一个带有头结点的链表的中间节点
 * 1-2-3-4-5 返回3
 * 1-2-3-4-5-6 返回4
 */
public class MidsideNode {
    /**
     * 快慢指针法：
     * 慢指针：每次指向下一个节点
     * 快指针：每次指向下一结点的下一个节点
     *
     * @param head
     * @return
     */
    public ListNode midesideNode(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }


}