package DataStructs.Tree;

public class BinaryTree {
    class Node {
        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val) {
            data = val;
            left = null;
            right = null;
            parent = null;
        }

    }

    private Node root;

    // new一个BinayTree生成一个空的根节点
    public BinaryTree() {
        root = null;
    }

    /**
     * 按照给定的值寻找相应的节点
     *
     * @param key
     * @return
     */
    public Node find(int key) {
        //根节点
        Node curr = root;
        while (curr != null) {
            //节点不存在  返回根节点
            if (key < curr.data) {
                if (curr.left == null) {
                    return curr;
                }

                curr = curr.left;

            } else if (key > curr.data) {
                if (curr.right == null) {
                    return curr;
                }
                curr = curr.right;
            } else {
                return curr;
            }


        }
        return null;
    }

    /**
     * 向二叉树插入特定的值
     * @param val
     */
    public void put(int val){
        Node newNode = new Node(val);
        //如果根节点为空，当前节点就是根节点
        if(root == null){
            root  = newNode;
        }else{
            Node parent = find(val);
            if(val < parent.data){
                parent.left = newNode;
                parent.left.parent = parent;
                return;
            }else{
                parent.right = newNode;
                parent.right.parent = parent;
                return ;
            }
        }
    }


    /**
     * 删除给定值
     * @param val
     * @return
     */
    public boolean remove(int val){
        //temp 即为要删除的节点
        Node temp = find(val);

        //此节点不存在
        if(temp.data != val){
            return false;
        }

        //此节点无子节点
        if(temp.right == null && temp.left == null){
            if(temp == root){
                root = null;
            }else if(temp.parent.data < temp.data){
                temp.parent.right = null;
            }else{
                temp.parent.left = null;
            }
            return false;
        }else if(temp.left !=null && temp.right!=null){
            Node successor = findSuccessor(temp);

            successor.left = temp.left;
            successor.left.parent = successor;
            if (successor.right != null && successor.parent != temp) {
                successor.right.parent = successor.parent;
                successor.parent.left = successor.right;
                successor.right = temp.right;
                successor.right.parent = successor;
            }
            if (temp == root) {
                successor.parent = null;
                root = successor;
                return true;
            }

            else {
                successor.parent = temp.parent;
if (temp.parent.data < temp.data)
                    temp.parent.right = successor;
                else
                    temp.parent.left = successor;
                return true;
            }
        }
        //One child
        else {
            //If it has a right child
            if (temp.right != null) {
                if (temp == root) {
                    root = temp.right;
                    return true;
                }

                temp.right.parent = temp.parent;

                //Assigns temp to left or right child
                if (temp.data < temp.parent.data)
                    temp.parent.left = temp.right;
                else
                    temp.parent.right = temp.right;
                return true;
            }
            //If it has a left child
            else {
                if (temp == root) {
                    root = temp.left;
                    return true;
                }

                temp.left.parent = temp.parent;

                //Assigns temp to left or right side
                if (temp.data < temp.parent.data)
                    temp.parent.left = temp.left;
                else
                    temp.parent.right = temp.left;
                return true;
            }
        }
    }


    /**
     * 中序遍历
     * @param localRoot
     */
    public void inOrder(Node localRoot) {

        if(localRoot != null){
            inOrder(localRoot.left);
            System.out.println(localRoot.data+" ");
            inOrder(localRoot.right);
        }
    }

    /**
     * 前序遍历
     * @param localRoot
     */
    public void preOrder(Node localRoot){
        if(localRoot !=null){
            System.out.println(localRoot.data+" ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    /**
     * 后序遍历
     * @param localRoot
     */
    public void postOrder(Node localRoot){
        if(localRoot != null){
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.println(localRoot.data+" ");
        }
}



    /**
     *此方法查找给定节点的后继节点。
     * @param n
     * @return
     */
    public Node findSuccessor(Node n){
        if(n.right == null){
            return n;
        }
        Node curr = n.right;
        Node parent = n.right;
        while(curr != null){
            parent = curr;
            curr = curr.left;
        }
        return parent;
    }

    public Node getRoot(){
        return root;
    }
}















