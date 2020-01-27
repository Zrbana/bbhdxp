package DataStructs.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalQueue {
    class Node{
        int data;
        Node left;
        Node right;

        public Node(int item){
            data = item;
            left = null;
            right = null;
        }
    }

    Node root;

    /**
     * 层序打印给定二叉树的节点
     */
    public void printLevelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            Node tempNode = queue.poll();
            System.out.println(tempNode.data + " ");

            if(tempNode.left != null){
                queue.add(tempNode.left);
            }

            if(tempNode.right!=null){
                queue.add(tempNode.right);
            }

        }

    }

}

















