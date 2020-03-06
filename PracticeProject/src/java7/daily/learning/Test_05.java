package java7.daily.learning;

/**
 * @ClassName Test_05
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/6 21:43
 */


public class Test_05 {
}
//删除单链表之间节点
class DeleteLink{
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}