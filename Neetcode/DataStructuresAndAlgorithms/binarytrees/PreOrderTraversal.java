package Neetcode.DataStructuresAndAlgorithms.binarytrees;

public class PreOrderTraversal {

    //we go level by level instead of node(Left to right) i.e
//    we print root note, and then its entire left nodes, and then it's right Nodes
    static void main() {
        TreeNode root = new TreeNode(4);

        // Level 1
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        // Level 2
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        preOrder(root);
    }
    public static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
