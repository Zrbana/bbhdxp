package java7.daily.learning.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName ReverseBinaryTree
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/1 22:03
 */

//翻转树
public class ReverseBinaryTree{

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        x = val;
    }
}

//方法一：递归
class Solution_01 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}




//方法二：迭代
    class Solution_02 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}