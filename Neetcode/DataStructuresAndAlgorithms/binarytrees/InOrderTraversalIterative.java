package Neetcode.DataStructuresAndAlgorithms.binarytrees;

import java.util.Stack;

public class InOrderTraversalIterative {

    //left root right
    void main() {
        TreeNode root = new TreeNode(4);

        // Level 1
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(6);

        // Level 2
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
//        dfsInorder(root);
        dfsPreOrder(root);
    }

    public void dfsInorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        //left root right
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.println(curr.val);
                curr = curr.right;
            }
        }

    }

    public void dfsPreOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        //root left right
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.println(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                curr = curr.left;
            } else {
                curr = stack.pop();
            }
        }
    }
}
