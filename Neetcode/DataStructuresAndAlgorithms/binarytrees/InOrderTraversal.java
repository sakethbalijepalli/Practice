package Neetcode.DataStructuresAndAlgorithms.binarytrees;

public class InOrderTraversal {


//    We will be traversing left to right. Go left on the parent node until we hit null, thats our base case
    // once we hit null we return and print the val and go right and print those values too.
    static void main() {
        TreeNode root = new TreeNode(4);

    // Level 1
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

    // Level 2
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        inorder(root);
    }
    public static void inorder(TreeNode node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }
}
