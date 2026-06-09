package Neetcode.DataStructuresAndAlgorithms.binarytrees;

public class ReverseOrderTraversal {

    static void main() {
        TreeNode root = new TreeNode(4);

        // Level 1
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        // Level 2
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        reverseOrder(root);
    }
    public static void reverseOrder(TreeNode node){
        if(node == null){
            return;
        }
        reverseOrder(node.right);
        System.out.println(node.val);
        reverseOrder(node.left);
    }
}
