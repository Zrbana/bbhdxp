package LinkedList.Implement.Applycation;

/**
 * 合并两个有序链表
 */
public class Merge {
    /**
     * 方法一：
     *  迭代法 设置一个指针，控制指针以完成两个链表的合并
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeLink(ListNode list1,ListNode list2){
        ListNode Head = new ListNode(-1);//用于返回合并后的链表
        ListNode prev = Head;
        while(list1!=null && list2!=null){
            //将指针指向较小的
            if(list1.val<list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }


        //如果其中一个链表为空，直接返回另一个不为空的链表
        prev.next=list1==null?list2:list1;
        return Head.next;
    }


    /**
     * 方法二
     *   递归法
     *   1.    l1.val<l2.val   --> l1.next = merge(l1.next,l2)
     *   2.    l2.val<l1.val   --> l2.next = merge(l2.next,l1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode merge_02(ListNode l1,ListNode l2){

        if(l1.val<l2.val){
            l1.next = merge_02(l1.next,l2);
            return l1;
        }
        if(l1.val>l2.val){
            l2.next = merge_02(l1,l2.next);
            return l2;
        }
        return l1 == null?l2:l1;
    }
}
