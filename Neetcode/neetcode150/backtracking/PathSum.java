package Neetcode.neetcode150.backtracking;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

public class PathSum {
    int sum = 0;

    void main() {
        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.left.left = new TreeNode(-5);
        System.out.println(hasPathSum(root,15));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        sum = sum + root.val;
        if(sum == targetSum && root.left == null && root.right == null){
            return true;
        }
        if(hasPathSum(root.left,targetSum)){
            return true;
        }
        if(hasPathSum(root.right,targetSum)){
            return true;
        }
        sum -= root.val;
        return false;
    }
}
