package LinkedList.Implement.Applycation;

/**
 * 删除值重复节点
 */
public class DeleteRepeatNode {
    public ListNode deleteRepeat(ListNode list){
        ListNode curr = list;

        while(curr!=null && curr.next!=null) {

            //检查当前节点的下一个节点，与当前节点值是否重复
            if (curr.next.val == curr.val) {
                list.next = list.next.next;
            }else{
                curr = curr.next;
            }

        }
        return list;
    }
}
