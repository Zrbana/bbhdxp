package DataStructs.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class GenericTree {
    private class Node {
        int data;
        ArrayList<Node> child = new ArrayList<>();
    }

    private Node root;
    private int size;

    public GenericTree() {     //Constructor
        Scanner scn = new Scanner(System.in);
        root = create_treeG(null, 0, scn);
    }

    private Node create_treeG(Node node, int childindx, Scanner scn) {
        // display
        if (node == null) {
            System.out.println("Enter root's data");
        } else {
            System.out.println("Enter data of parent of index " + node.data + " " + childindx);
        }
        // input
        node = new Node();
        node.data = scn.nextInt();
        System.out.println("number of children");
        int number = scn.nextInt();
        for (int i = 0; i < number; i++) {
            Node child = create_treeG(node, i, scn);
            size++;
            node.child.add(child);
        }
        return node;
    }

    /**
     * 打印树
     */
    public void display() {  //Helper function
        display_1(root);
    }

    private void display_1(Node parent) {
        System.out.print(parent.data + "=>");
        for (int i = 0; i < parent.child.size(); i++) {
            System.out.print(parent.child.get(i).data + " ");
        }
        System.out.println(".");
        for (int i = 0; i < parent.child.size(); i++) {
            display_1(parent.child.get(i));
        }
    }

    /**
     * 直接调用存储大小
     * @return size
     */
    public int size2call() {
        return size2(root);
    }

    /**
     * 计算存储大小
     * @param roott
     * @return
     */
    public int size2(Node roott) {
        int sz = 0;
        for (int i = 0; i < roott.child.size(); i++) {
            sz += size2(roott.child.get(i));
        }
        return sz + 1;
    }

    /**
     * 计算最大值
     * @return maximum value
     */
    public int maxcall() {
        int maxi = root.data;
        return max(root, maxi);
    }

    private int max(Node roott, int maxi) {
        if (maxi < roott.data)
            maxi = roott.data;
        for (int i = 0; i < roott.child.size(); i++) {
            maxi = max(roott.child.get(i), maxi);
        }

        return maxi;
    }

    /**
     * 计算树的高度
     * @return height
     */
    public int heightcall() {
        return height(root) - 1;
    }

    private int height(Node node) {
        int h = 0;
        for (int i = 0; i < node.child.size(); i++) {
            int k = height(node.child.get(i));
            if (k > h)
                h = k;
        }
        return h + 1;
    }

    public boolean findcall(int info) {
        return find(root, info);
    }

    private boolean find(Node node, int info) {
        if (node.data == info)
            return true;
        for (int i = 0; i < node.child.size(); i++) {
            if (find(node.child.get(i), info))
                return true;
        }
        return false;
    }


    /**
     *计算树的深度
     * @param dep depth
     */
    public void depthcaller(int dep) {
        depth(root, dep);
    }

    public void depth(Node node, int dep) {
        if (dep == 0) {
            System.out.println(node.data);
            return;
        }
        for (int i = 0; i < node.child.size(); i++)
            depth(node.child.get(i), dep - 1);
        return;
    }

    /**
     * 前序遍历
     */
    public void preordercall() {
        preorder(root);
        System.out.println(".");
    }

    private void preorder(Node node) {
        System.out.print(node.data + " ");
        for (int i = 0; i < node.child.size(); i++)
            preorder(node.child.get(i));
    }

    /**
     * 后序遍历
     */
    public void postordercall() {
        postorder(root);
        System.out.println(".");
    }

    private void postorder(Node node) {
        for (int i = 0; i < node.child.size(); i++)
            postorder(node.child.get(i));
        System.out.print(node.data + " ");
    }

    /**
     * 层序遍历
     */
    public void levelorder() {
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int k = q.getFirst().data;
            System.out.print(k + " ");

            for (int i = 0; i < q.getFirst().child.size(); i++) {
                q.addLast(q.getFirst().child.get(i));
            }
            q.removeFirst();
        }
        System.out.println(".");
    }

    /**
     * 删除所有叶子节点
     */
    public void removeleavescall() {
        removeleaves(root);
    }

    private void removeleaves(Node node) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < node.child.size(); i++) {
            if (node.child.get(i).child.size() == 0) {
                arr.add(i);
                // node.child.remove(i);
                // i--;
            } else
                removeleaves(node.child.get(i));
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            node.child.remove(arr.get(i) + 0);
        }
    }

}
