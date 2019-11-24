package LinkedList.Implement.Applycation;


    /**
     * 删除链表的某个中间节点
     * 如：4->5->1->9  要删除值为5的节点
     * 变成4->1->9
     * 由于单链表，找不到前驱节点，所以只能将5的值改为1，此时指针指向第二个节点
     * 下一步，将指针指向9即可
     *
     */
    public class DeleteNode {
        public void delete(ListNode list){
            //将5的值修改成1
            list.val = list.next.val;
            //将指针指向9
            list.next = list.next.next;

        }

    }


