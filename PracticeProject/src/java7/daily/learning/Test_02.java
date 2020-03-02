package java7.daily.learning;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Test_02
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/2 21:42
 */

public class Test_02 {

}


/**
 * 小A和小B在玩猜数字，小B每次从1,2,3中随机选择一个，小A每次也从1,2,3中选择一个
 * 一共进行三次这个游戏，请返回小A猜对了几次
 */
class Resolve {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

}
class Resolve_02{

    //实现一个算法，确定一个字符串s的所有字符是否全部不同
    public boolean isUnique(String astr) {
        long low64 = 0;
        long high64 = 0;

        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bitIndex = 1L << c - 64;
                if ((high64 & bitIndex) != 0) {
                    return false;
                }

                high64 |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((low64 & bitIndex) != 0) {
                    return false;
                }

                low64 |= bitIndex;
            }

        }

        return true;
    }

}

class Resolve_03{
    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，
     * 实现基本的字符串压缩功能。比如，
     * 字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
     * 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     *
     */

    public String compressString(String S) {
        if (S.isEmpty()) {
            return S;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(S.charAt(0));
        int count = 1;
        for (int i = 1; i < S.length(); ++i) {
            if (builder.charAt(builder.length() - 1) == S.charAt(i)) {
                ++count;
            } else {
                builder.append(count);
                count = 1;
                builder.append(S.charAt(i));
            }
        }
        builder.append(count);
        return builder.length() >= S.length() ? S : builder.toString();
    }

}

class Resolve_04{
    //编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
      private class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
     
    class Solution {
        private Set<Integer> set=new HashSet<>();
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head==null)
                return null;
            if (!set.contains(head.val)){
                set.add(head.val);
                head.next=removeDuplicateNodes(head.next);
                return head;
            }
            else{
                return removeDuplicateNodes(head.next);
            }
        }
    }

}