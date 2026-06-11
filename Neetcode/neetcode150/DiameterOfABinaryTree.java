package Neetcode.neetcode150;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class DiameterOfABinaryTree {
    static int leftHeight = 0;
    static int rightHeight = 0;

    static void main() {
        TreeNode root = new TreeNode(1);

// Level 1: 2 is the left child, 3 is the right child
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

// Level 2:
// 2's children are null, so we skip them.
// 3's left child is 4, 3's right child is null.
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int pathThroughRoot = height(root.left) + height(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(pathThroughRoot, Math.max(leftDiameter, rightDiameter));
    }

    private static int height(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
