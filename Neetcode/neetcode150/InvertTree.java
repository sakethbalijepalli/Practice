package Neetcode.neetcode150;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class InvertTree {

    static void main() {
        // Root Level
        TreeNode root = new TreeNode(1);

// Level 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

// Level 2 (Left children)
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

// Level 2 (Right children)
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {

        return dfs(root);
    }

    private static TreeNode dfs(TreeNode root){
        if(root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = dfs(root.right);
        node.right = dfs(root.left);
        return node;
    }
}
