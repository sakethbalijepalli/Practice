package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class BalancedBinaryTree {
   boolean res;

    static void main() {
        // Root level
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root) {
        return traverseBottomUp(root) != -1;
    }

    private static int traverseBottomUp(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = traverseBottomUp(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = traverseBottomUp(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
