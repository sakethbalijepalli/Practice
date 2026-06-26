package Neetcode.DataStructuresAndAlgorithms.backtracking;

import Neetcode.DataStructuresAndAlgorithms.binarytrees.TreeNode;

import java.util.Stack;

public class CanReachLeafWithoutZero {
    void main() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(0);
        System.out.println(canReach(root));
        Stack<Integer> stack = new Stack<>();
        buildAPathWithoutZero(root,stack);
        System.out.println(stack);
    }

    public boolean canReach(TreeNode root){
        if(root == null || root.val == 0){
            return false;
        }

        if(root.left == null && root.right == null){
            return true;
        }
        if(canReach(root.left)){
            return true;
        }
        if(canReach(root.right)){
            return true;
        }
        return false;
    }

    public boolean buildAPathWithoutZero(TreeNode root, Stack<Integer> stack){
        if(root == null || root.val == 0){
            return false;
        }
        stack.push(root.val);

        if(root.left == null && root.right == null){
            return true;
        }
        if(buildAPathWithoutZero(root.left,stack)){
            return true;
        }
        if(buildAPathWithoutZero(root.right,stack)){
            return true;
        }
        stack.pop();
        return false;
    }
}
