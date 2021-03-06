package DataStructs.Tree;

public class LevelOrderTraversal {

    class Node{
        int data;
        Node left;
        Node right;

        public Node(int item){
            data = item;
            left = right = null;
        }

    }

    Node root;

    public LevelOrderTraversal(){
        root = null;
    }

    void printLevelOrder(){
        int h = height(root);
        for(int i = 1;i<=h;i++){
            printGivenLevel(root,i);
        }
    }


    /**
     *
     * 计算树的高度
     * @param root
     * @return
     */
   public int height(Node root){
        if(root == null){
            return 0;
        }else{
            return Math.max(height(root.left),height(root.right))+1;
        }
    }

    public void printGivenLevel(Node root,int level){
       if(root == null){
           return;
       }
       if(level == 1){
           System.out.println(root.data+" ");
       }else if(level>1){
           printGivenLevel(root.left,level-1);
           printGivenLevel(root.right,level-1);
       }
    }

}












