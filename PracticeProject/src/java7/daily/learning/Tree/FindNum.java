package java7.daily.learning.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName FindNum
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/1 22:10
 */

//二叉搜索树中第k个大的数
public class FindNum {

}

//方法一：递归
class Solution {
        public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
            if (root == null) return arr;
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
            return arr;
        }

        public int kthSmallest(TreeNode root, int k) {
            ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
            return nums.get(k - 1);
        }
}



//方法二：迭代
class Solution02{
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}

