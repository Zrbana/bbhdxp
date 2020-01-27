package DataStructs.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//测试方法
public class PrintTopViewofTree {
    public static void main(String[] args) {
        /* 创建如下二叉树
             1
           /  \
          2    3
           \
            4
             \
              5
               \
                6*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        Tree t = new Tree(root);
        System.out.println("Following are nodes in top view of Binary Tree");
        t.printTopView();

    }

}

//二叉树节点
class TreeNode{
  //成员
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key){
        this.key = key;
        left = null;
        right = null;
    }

}

/**
 * 表示队列项的类，队列用于层序遍历，每个队列项包含节点和水平节点到根的距离
 */
class QItem{
    TreeNode node;
    int hd;

    public QItem(TreeNode n, int h){
        node = n;
        hd = h;
    }
}

class Tree{
    TreeNode root;
    public Tree(){
        root = null;
    }
    public Tree(TreeNode n){
        root = n;
    }
    //打印节点
    public void printTopView(){
        if(root == null){
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        Queue<QItem> queue = new LinkedList<>();
        queue.add(new QItem(root,0));//根的水平距离为零

        //层序遍历循环
        while(!queue.isEmpty()){
            QItem q = queue.remove();
            int hd = q.hd;
            TreeNode n = q.node;


            if(!set.contains(hd)){
                set.add(hd);
                System.out.println(n.key + " ");
            }

           // 对当前节点的左右子节点进行排列
            if(n.left != null){
                queue.add(new QItem(n.left,hd-1));
            }
            if(n.right != null){
                queue.add(new QItem(n.right,hd+1));
            }
        }

    }

}







































