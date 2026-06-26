package Neetcode.neetcode150.trees;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class KthSmallestElement {
    static int count = 0;
    static int result = 0;
    static void main() {
        TreeNode root = new TreeNode(4);

// Level 1
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);

// Level 2 (2 is the left child of 3)
        root.left.left = new TreeNode(2);
        System.out.println(kthSmallest(root,4));
    }

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        dfs(root,k);
        return result;
    }

    private static void dfs(TreeNode root,int k){
        if (root == null || count >= k) return;
        dfs(root.left,k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        dfs(root.right,k);
    }
}
