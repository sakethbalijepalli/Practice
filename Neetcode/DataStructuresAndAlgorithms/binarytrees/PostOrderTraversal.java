package Neetcode.DataStructuresAndAlgorithms.binarytrees;

public class PostOrderTraversal {

    static void main() {
        TreeNode root = new TreeNode(4);

        // Level 1
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        // Level 2
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        postOrder(root);
    }
    public static void postOrder(TreeNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }
}
