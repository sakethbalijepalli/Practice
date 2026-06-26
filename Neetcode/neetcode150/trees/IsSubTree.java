package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class IsSubTree {
    void main() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        TreeNode sub = new TreeNode(2);
        sub.left = new TreeNode(4);
        sub.right = new TreeNode(5);
        System.out.println(isSubtree(node,sub));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // Check if the match starts HERE, or down the LEFT, or down the RIGHT
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root,TreeNode subRoot){
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        return (root.val == subRoot.val) &&
                isSameTree(root.left, subRoot.left) &&
                isSameTree(root.right, subRoot.right);
    }
}
